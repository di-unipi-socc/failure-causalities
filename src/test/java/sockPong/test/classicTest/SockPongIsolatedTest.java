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

public class SockPongIsolatedTest {
    public static void main(String[] args) {

        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.ISOLATED_FAULT.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1604239007.3137524", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604239008.8466222", "stop");
        String i = "60f73667527906bb4380b1f4cf77ffb9d068747ac1cc95836a172f69f39efc0a";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);

    }
}
