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

public class SockPongWaterfallTest {
    public static void main(String[] args) {
        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.WATERFALL_FAULT.toString());
        lm.readLogFile();

        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1604252057.7335348", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604252061.741119", "faulted");
        String i = "42c671b904f25f45fef793becfc2f16cdf3b9430727922f5b7401d8f43d32d28";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);
    }
}
