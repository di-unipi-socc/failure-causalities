package sockPong.test;

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

public class SockPongHalfWaterfall {
    public static void main(String[] args) {

        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.HALF_WATERFALL_FAULT.toString());
        lm.readLogFile();

        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1604330143.9702165", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604330143.9906514", "faulted");
        String i = "65bc64b5091e185c86a3b695990d4b13a75fa47932cc2fc5631acafd6c166f25";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app, 3.0);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);
    }
}
