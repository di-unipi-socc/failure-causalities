package pongTest;

import canalyzer.algorithm.CustomPair;
import canalyzer.algorithm.WhyAlgorithm;
import canalyzer.algorithm.eventType.WhyEvent;
import canalyzer.utilities.log.LogFormat;
import canalyzer.utilities.log.LogManager;
import com.google.gson.Gson;
import model.Application;

import java.util.ArrayList;
import java.util.Hashtable;

public class PongWaterfallTest {
    public static void main(String[] args) {
        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.WATERFALL.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = PongTopologyTest.make21Topology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1603980814.5861402", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1603980818.6181648", "faulted");
        String i = "a064e1b0cbc7e4cbe9cb59765acb84110a13e200dc16290fe29ea53996e2ddec";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);
    }
}
