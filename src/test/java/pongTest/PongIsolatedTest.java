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

public class PongIsolatedTest {
    public static void main(String[] args) {

        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.ISOLATED_FAULT.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = PongTopologyTest.make21Topology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1603981074.698575", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1603981078.0103052", "stop");
        String i = "867307499a88dd0cda963da4adb23bce5f5495ead0b8f912d26e3050aef671e3";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);

    }
}
