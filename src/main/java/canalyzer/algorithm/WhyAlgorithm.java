package canalyzer.algorithm;

import canalyzer.algorithm.eventType.CausesEvent;
import canalyzer.algorithm.eventType.CrashEvent;
import canalyzer.algorithm.eventType.WhyEvent;
import canalyzer.utilities.log.LogFormat;
import canalyzer.utilities.log.LogManager;
import canalyzer.utilities.log.LogOp;
import model.Application;
import model.Node;
import model.Requirement;
import model.StaticBinding;

import java.util.*;

public class WhyAlgorithm {
    private static int lineRead;

    /**
     * Return the causality graph
     *
     * @param i       instance
     * @param ts      timestamp and state for i
     * @param tSFirst timestamp' and state' for i
     * @param logs    event logs
     * @param A       application specification
     * @return the causality graph for i
     */
    public static WhyEvent why(String i,
                               CustomPair<String, String> ts,
                               CustomPair<String, String> tSFirst,
                               Hashtable<String, ArrayList<LogFormat>> logs,
                               Application A) {

        // Initializing causality graph
        String nodeName = logs.get(i).get(0).getNodeName();
        WhyEvent result = new CausesEvent(i, nodeName, ts, tSFirst);
        ArrayList<WhyEvent> events = new ArrayList<>(Collections.singletonList(result));

        // Counter of the logs read
        lineRead = 0;

        //Explain events
        ArrayList<WhyEvent> toBeExplained = new ArrayList<>(Collections.singletonList(result));
        while (!toBeExplained.isEmpty()) {
            //toBExp is the first element in the list to be explained
            CausesEvent toBExp = (CausesEvent) toBeExplained.remove(0);

            //Check if event is "truly" to be explained
            List<String> tmpOps = A.getNodes().get(toBExp.getNodeName()).getOps();
            if (!tmpOps.contains(toBExp.getTSFirst().get_info())) {
                //Node instances always can "unexpectedly fail"
                toBExp.addCause(new CrashEvent(toBExp.getInstance(), toBExp.getNodeName(), true));
                events.add(toBExp);

                //Can the event also be caused by a fault handler?
                Node N = A.getNodes().get(logs.get(toBExp.getInstance()).get(0).getNodeName());
                String x = toBExp.getTS().get_info();
                String xf = toBExp.getTSFirst().get_info();
                // Check if the pair <x,x'> is in the fault handler of N
                if (checkFaultHandler(N.getManagementProtocol().getPhi(), x, xf)) {
                    // If yes,isolate starting time for state x and...
                    // txSecond is equivalent to <t'',x''> in theoretical Why algorithm
                    CustomPair<String, String> txSecond = new CustomPair<>(toBExp.getTS().get_time(), toBExp.getTS().get_info());
                    String tStart = txSecond.get_time();
                    ArrayList<LogFormat> iLogs = LogManager.getInstance().getLogsByNodeIdOrNodeContainerId(i);
                    while (txSecond.get_info().equals(toBExp.getTS().get_info()) && previousInLogs(previous(txSecond.get_time(), iLogs), iLogs)) {
                        tStart = txSecond.get_time();
                        txSecond = previous(txSecond.get_time(), iLogs);
                    }
                    //...explain each possibly faulted requirement
                    List<Requirement> pFaultedRequirements = possiblyFaultedRequirements(
                            N.getManagementProtocol().getRho().get(x),
                            N.getManagementProtocol().getRho().get(xf)
                    );
                    for (Requirement r : pFaultedRequirements) {
                        String M = A.getBindingFunction().get(new StaticBinding(N.getName(), r.getName())).getNodeName();
                        // If r is "host", check its container
                        ArrayList<String> causingInstances;
                        if (r.isContainment()) {
                            causingInstances = LogManager.getInstance().getNodeContainerIdByNodeNameNodeId(N.getName(), i);
                        }
                        //Otherwise, check any instance that can satisfy r
                        else {
                            causingInstances = LogManager.getInstance().getNodeIdListByNodeName(M);
                        }
                        for (String j : causingInstances) {
                            ArrayList<LogFormat> jLog = LogManager.getInstance().getLogsByNodeIdOrNodeContainerId(j);
                            if (previousInLogs(previous(tStart, jLog), jLog)){
                                String jNodeName = jLog.get(0).getNodeName();
                                // uy is equivalent to <u,y> of Why theoretical algorithm
                                CustomPair<String, String> uy = previous(tStart, jLog);
                                // uyFirst is equivalent to <u',y'> of Why theoretical algorithm
                                CustomPair<String, String> uyFirst = previous(toBExp.getTSFirst().get_time(), jLog);
                                lineRead+=2;
                                while (LogOp.compareTs(uyFirst.get_time(), uy.get_time()) >= 0 &&
                                        checkIfBelongsTo(r, N.getName(), M, uyFirst.get_info(), A)) {
                                    uyFirst = previous(uyFirst.get_time(), jLog);
                                    ++lineRead;
                                }
                                CustomPair<String, String> vW = new CustomPair<>();
                                while (LogOp.compareTs(uyFirst.get_time(), uy.get_time()) >= 0 &&
                                        !checkIfBelongsTo(r, N.getName(), M, uyFirst.get_info(), A)) {
                                    vW.setAll(uyFirst.get_time(), uyFirst.get_info());
                                    uyFirst = previous(uyFirst.get_time(), jLog);
                                    ++lineRead;
                                }
                                if (LogOp.compareTs(uyFirst.get_time(), uy.get_time()) >= 0) {
                                    WhyEvent c = new CausesEvent(j, jNodeName, uyFirst, vW);
                                    if (!events.contains(c)) {
                                        toBeExplained.add(c);
                                    }
                                    events.add(c);
                                    toBExp.addCause(c);
                                }
                                else{
                                    lineRead-=2;
                                }
                            }

                        }
                    }
                }
            }
        }

        // Prints the number of log's line parsed with Why
//        System.out.println("Logs read: " + lineRead);
        // Return causality graph
        return result;
    }

    /**
     * Return true if <x,x'> is in the phi of N
     *
     * @param phi phi of N
     * @param x   first state
     * @param xF  second state
     * @return return true if <x,xF> is in phi
     */
    private static boolean checkFaultHandler(Map<String, List<String>> phi, String x, String xF) {
        List<String> states = phi.get(x);
        if (states != null) {
            return states.contains(xF);
        }
        return false;
    }

    /**
     * Return the difference between the two rho
     *
     * @param rhoX  Rho of x
     * @param rhoXF Rho of x'
     * @return list with the difference
     */
    private static List<Requirement> possiblyFaultedRequirements(List<Requirement> rhoX, List<Requirement> rhoXF) {
        List<Requirement> tmp = new ArrayList<>(rhoX);
        tmp.removeAll(rhoXF);
        return tmp;
    }

    /**
     * Returns the first element with the timestamp less than t if present, empty otherwise
     *
     * @param t    timestamp reference
     * @param logs Arraylist with logs to examine
     * @return CustomPair contains the first element with the timestamp less than t or an empty one
     */
    private static CustomPair<String, String> previous(String t, ArrayList<LogFormat> logs) {
        ListIterator<LogFormat> iterator = logs.listIterator(logs.size());
        double tD = Double.parseDouble(t);
        while (iterator.hasPrevious()) {
            LogFormat tmp = iterator.previous();
            if (LogOp.compareTs(Double.toString(tD), tmp.getTimestamp()) > 0) {
                ++lineRead;
                return new CustomPair<>(tmp.getTimestamp(), tmp.getInfo());
            }
        }
        return new CustomPair<>("", "");
    }

    /**
     * Return true if the elements inside pair is in the array
     *
     * @param pair pair containing timestamp and info of one LogFormat
     * @param logs arrayList with log
     * @return true if pair inside logs, false otherwise
     */
    private static boolean previousInLogs(CustomPair<String, String> pair, ArrayList<LogFormat> logs) {
        for (LogFormat logElement : logs) {
            if (LogOp.compareTs(logElement.getTimestamp(), pair.get_time()) == 0 && logElement.getInfo().equals(pair.get_info())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return true if b(r) is a capability that belongs to the set of possible capabilities offered by M in the y' state
     * false otherwise
     *
     * @param r      Requirement associated to the capability to check
     * @param N      Node of which r is requirement
     * @param M      Node that potentially offer that capability
     * @param yFirst state in which M offers that capability
     * @param A      Application in which M is a Node
     * @return True if M's gamma function contains the capability that satisfied r in the state y'
     */
    private static boolean checkIfBelongsTo(Requirement r, String N, String M, String yFirst, Application A) {
        String caps = A.getBindingFunction().get(new StaticBinding(N, r.getName())).getCapOrReq();
        Node nodeM = A.getNodes().get(M);
        Map<String, List<String>> gammaM = nodeM.getManagementProtocol().getGamma();
        List<String> capsOffered = gammaM.get(yFirst);
        if (capsOffered == null)
            return false;
        return capsOffered.contains(caps);
    }


}
