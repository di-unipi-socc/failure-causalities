package canalyzer.algorithm.eventType;

import canalyzer.algorithm.CustomPair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CausesEvent extends WhyEvent {

    // < t , s > -> timestamp and state
    private CustomPair<String, String> tS;
    // < t' , s' > -> timestamp and state after event
    private CustomPair<String, String> tSFirst;
    //causes
    private ArrayList<WhyEvent> causes;

    public CausesEvent(@NotNull String instance,
                       @NotNull String nodeName,
                       CustomPair<String, String> tS,
                       CustomPair<String, String> tSFirst) {
        super(instance, nodeName);
        this.tS = tS;
        this.tSFirst = tSFirst;
        this.causes = new ArrayList<>();
    }

    public CustomPair<String, String> getTS() {
        return tS;
    }

    public CustomPair<String, String> getTSFirst() {
        return tSFirst;
    }

    public void addCause(WhyEvent e) {
        causes.add(e);
    }

    public ArrayList<WhyEvent> getCauses() {
        return causes;
    }


    @Override
    public String toString() {
        return "{" +
                "instance: " + super.getInstance() +
                "nodeName:" + super.getNodeName()  +
                "< t , s >:" + "< " + tS.get_time() + " , " + tS.get_info() + " >" +
                "< t' , s' >:" + "< " + tSFirst.get_time() + " , " + tSFirst.get_info() + " >"+
                "causes: " + causes +
                "}"
                ;

    }
}
