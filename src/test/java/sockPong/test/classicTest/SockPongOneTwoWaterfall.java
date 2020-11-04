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

public class SockPongOneTwoWaterfall {
    public static void main(String[] args) {
        //Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(LogFiles.ONE_TWO_WATERFALL.toString());
        lm.readLogFile();

        //Creates topology of 21/10/2020
        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter
        CustomPair<String,String> ts = new CustomPair<>("1604400139.3963125", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604400140.4041817", "faulted");
        String i = "e918a2a53ba5a7824ac7e3f5641bd547352f15aead50238c20a7209b1abe97f6";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        Gson gson = new Gson();
        String printable = gson.toJson(p);
        System.out.println(printable);
    }
}
