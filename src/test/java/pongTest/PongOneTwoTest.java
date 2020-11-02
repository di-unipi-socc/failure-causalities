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

public class PongOneTwoTest {
    public static void main(String[] args) {

        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.ONE_TWO_FAULT.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = PongTopologyTest.make21Topology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1603980944.3535664", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1603980948.438665", "faulted");
        String i = "71f72cf542c2accf04fc7fde9053369032c151e7f0f32a5c72450025aed552c4";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app, 3.0);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);

    }
}
