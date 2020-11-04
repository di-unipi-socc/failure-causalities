package sockPong.test.classicTest;

import canalyzer.algorithm.CustomPair;
import canalyzer.algorithm.WhyAlgorithm;
import canalyzer.algorithm.eventType.WhyEvent;
import canalyzer.utilities.log.LogFormat;
import canalyzer.utilities.log.LogManager;
import com.google.gson.Gson;
import model.Application;
import sockPong.topology.SockPongTopology;

import java.util.ArrayList;
import java.util.Hashtable;

public class SockPongTwoComponent {
    public static void main(String[] args) {

        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.TWO_COMPONENT_WATERFALL.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1604400280.0690422", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604400281.0757217", "faulted");
        String i = "ef4909a24d82d40b72e16edc586a48a926635220f2a274c09f9d28e4e5eb570d";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);
    }
}
