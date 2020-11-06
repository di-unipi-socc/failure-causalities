package sockPong.test.chaos;

import canalyzer.algorithm.CustomPair;
import canalyzer.algorithm.WhyAlgorithm;
import canalyzer.algorithm.eventType.WhyEvent;
import canalyzer.utilities.log.LogFormat;
import canalyzer.utilities.log.LogManager;
import com.google.gson.Gson;
import model.Application;
import sockPong.test.chaos.files.ChaosLogFiles11to20;
import sockPong.test.chaos.files.ChaosLogFiles1to10;
import sockPong.test.chaos.files.ChaosLogFiles21to30;
import sockPong.topology.SockPongTopology;

import java.util.ArrayList;
import java.util.Hashtable;

public class Chaos {
    public static void testChaos1to10() {

        Gson gson = new Gson();


        // Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(ChaosLogFiles1to10.CHAOS1.toString());
        lm.readLogFile();

        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter for Chaos1
        CustomPair<String,String> ts = new CustomPair<>("1604503052.868829", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604503053.8741322", "faulted");
        String i = "c4093865100c3be6f0b895de864dde5629a76e9d71fc0c46880ba9a05efff312";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        String printable = gson.toJson(p);
        System.out.println("Chaos1: ");
        System.out.println(printable);

        System.out.println("-------------------------------------------------------------------------------------");

        // Why algorithm for Chaos2
        lm.setLogFile(ChaosLogFiles1to10.CHAOS2.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604504759.8249311", "running");
        tsFirst = new CustomPair<>("1604504760.8331242", "faulted");
        i = "5d8da105ffe64e075781c7915402c4d98b8a2a05a9a89704bfe06f6d685c9534";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos2: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos3
        lm.setLogFile(ChaosLogFiles1to10.CHAOS3.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505153.146621", "running");
        tsFirst = new CustomPair<>("1604505155.17712", "faulted");
        i = "805a46898254403ae68bd972bc412fd4fb8ed87aa70f3606f95bd7d9e27736fe";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos3: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos4
        lm.setLogFile(ChaosLogFiles1to10.CHAOS4.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505269.0901012", "running");
        tsFirst = new CustomPair<>("1604505270.3296633", "faulted");
        i = "e42fc04474cf67e3c69914ab5c6fdb3c5a6ebf185eacdc68531de0a3cb49ce4e";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos4: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos5
        lm.setLogFile(ChaosLogFiles1to10.CHAOS5.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505401.4647188", "running");
        tsFirst = new CustomPair<>("1604505402.4833488", "faulted");
        i = "5af14f32881734272e9712bc758bdeacdd9544d9fd2d29d58093aae3a5fd0a71";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos5: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos6
        lm.setLogFile(ChaosLogFiles1to10.CHAOS6.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505970.945891", "running");
        tsFirst = new CustomPair<>("1604505971.9530907", "faulted");
        i = "650cfb6395068afa61aefac780991df430d68838e3ccf15d8ae2cabcddff35b4";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos6: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos7
        lm.setLogFile(ChaosLogFiles1to10.CHAOS7.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604507381.6539037", "running");
        tsFirst = new CustomPair<>("1604507383.663012", "faulted");
        i = "fd63fe6152efd102bd87cb937ebb9f9c2a92e526ac8308908d215c9fe240c03f";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos7: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos8
        lm.setLogFile(ChaosLogFiles1to10.CHAOS8.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505676.5701952", "running");
        tsFirst = new CustomPair<>("1604505678.5972779", "faulted");
        i = "b29c0f42c20ca7919ed0844815f9b9d745cdfbf64174a202f0a1980fb2d643a2";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos8: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos9
        lm.setLogFile(ChaosLogFiles1to10.CHAOS9.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604505796.7317443", "running");
        tsFirst = new CustomPair<>("1604505798.7512248", "faulted");
        i = "54daffa9a30d862799386f591bbd93eecc0d845f4f939f313c67998b8c2e37c7";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos9: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos10
        lm.setLogFile(ChaosLogFiles1to10.CHAOS10.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604506128.5737083", "running");
        tsFirst = new CustomPair<>("1604506129.5859592", "faulted");
        i = "aaac69481bc1d9f0a0733ae8290d0e8dcb698a93366c8a3f3040da3ceb067288";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos10: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");


    }

    public static void testChaos11to20(){
        Gson gson = new Gson();


        // Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(ChaosLogFiles11to20.CHAOS11.toString());
        lm.readLogFile();

        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter for Chaos11
        CustomPair<String,String> ts = new CustomPair<>("1604566104.7856433", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604566106.8039083", "faulted");
        String i = "bb07c2e6a58ca504c8bb5d37659e9294e68698a355f71ea4e85bb6412b6aa469";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        String printable = gson.toJson(p);
        System.out.println("Chaos11: ");
        System.out.println(printable);

        System.out.println("-------------------------------------------------------------------------------------");

        // Why algorithm for Chaos12
        lm.setLogFile(ChaosLogFiles11to20.CHAOS12.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604566225.3705575", "running");
        tsFirst = new CustomPair<>("1604566227.389768", "faulted");
        i = "85bb356140584834ceb6514947953b576a94e7dc3a46a258675b52227b6511ba";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos12: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos13
        lm.setLogFile(ChaosLogFiles11to20.CHAOS13.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604566350.4342806", "running");
        tsFirst = new CustomPair<>("1604566351.4461143", "faulted");
        i = "6cc68e4fc1b86c79d51c62c3240c0183e73da296e837e70fd4707420610cd44b";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos13: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos14
        lm.setLogFile(ChaosLogFiles11to20.CHAOS14.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604566504.362694", "running");
        tsFirst = new CustomPair<>("1604566505.3788095", "faulted");
        i = "034da7c6d8495cb889b8c1b5c64433492c91627857e3ae70edab2bb1abeb7dfe";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos14: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos15
        lm.setLogFile(ChaosLogFiles11to20.CHAOS15.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604566683.7271683", "running");
        tsFirst = new CustomPair<>("1604566684.735155", "faulted");
        i = "74b8b127219869e948a241ba7b82c17d50b56af7482978ced9b360d0156c566c";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos15: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos16
        lm.setLogFile(ChaosLogFiles11to20.CHAOS16.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604566943.442632", "running");
        tsFirst = new CustomPair<>("1604566944.4510186", "faulted");
        i = "57b94a674e9efd4f005f2dee8fb529b80fb14b69fc43cfafe7cd9f006bf56412";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos16: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos17
        lm.setLogFile(ChaosLogFiles11to20.CHAOS17.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604567163.816244", "running");
        tsFirst = new CustomPair<>("1604567163.362812", "stop");
        i = "54c0b4d08391834af113c9b92ce49910a904d5cabedb77006835c9eec2531092";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos17: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos18
        lm.setLogFile(ChaosLogFiles11to20.CHAOS18.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604567329.338024", "running");
        tsFirst = new CustomPair<>("1604567330.3551586", "faulted");
        i = "009cfdd4fae66e08dab2f47f52ce29ceb7299e6b0dea4dfc47e5b8ce3ae93772";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos18: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos19
        lm.setLogFile(ChaosLogFiles11to20.CHAOS19.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604567453.6419938", "running");
        tsFirst = new CustomPair<>("1604567454.646177", "faulted");
        i = "22aabf97ca541f6cfaf172172331ceca115711a5537190ecc2b4b013800cc552";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos19: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos20
        lm.setLogFile(ChaosLogFiles11to20.CHAOS20.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604567611.8559527", "running");
        tsFirst = new CustomPair<>("1604567612.8635566", "faulted");
        i = "5f74f077ac92e25d5f0428707ba94dee3782d52db068bb4ff81b514114658381";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos20: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static void testChaos21to30(){
        Gson gson = new Gson();


        // Create LogManager
        LogManager lm = LogManager.getInstance();
        lm.setLogFile(ChaosLogFiles21to30.CHAOS21.toString());
        lm.readLogFile();

        Application app = SockPongTopology.sockPongTopology();

        // Initializing Why parameter for Chaos21
        CustomPair<String,String> ts = new CustomPair<>("1604571641.843148", "running");
        CustomPair<String,String> tsFirst = new CustomPair<>("1604571642.8468482", "faulted");
        String i = "c0bba013a4f879f339712efbdf4b499665d5bd6bcb3c11e9cf3303da1d978d0e";
        Hashtable<String, ArrayList<LogFormat>> logs = LogManager.getInstance().getLogs();

        WhyEvent p =  WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        String printable = gson.toJson(p);
        System.out.println("Chaos21: ");
        System.out.println(printable);

        System.out.println("-------------------------------------------------------------------------------------");

        // Why algorithm for Chaos22
        lm.setLogFile(ChaosLogFiles21to30.CHAOS22.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570152.8850157", "running");
        tsFirst = new CustomPair<>("1604570153.8964303", "faulted");
        i = "e54d3716241147f977da485ad48a7390789a76cdc46b93652c8e906b27e8035d";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos22: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos23
        lm.setLogFile(ChaosLogFiles21to30.CHAOS23.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570254.1892626", "running");
        tsFirst = new CustomPair<>("1604570255.1941745", "faulted");
        i = "fa166342fa22061a365c115bd140ebeebb45a70f60b27128f97ed616a34fc2c3";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos23: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos24
        lm.setLogFile(ChaosLogFiles21to30.CHAOS24.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570390.877437", "running");
        tsFirst = new CustomPair<>("1604570391.881797", "faulted");
        i = "9b171bf0dfdafe755eb1795c6d99ebb7cb1cc6345d3bf5d135a31cbdb603580e";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos24: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos25
        lm.setLogFile(ChaosLogFiles21to30.CHAOS25.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570652.4240696", "running");
        tsFirst = new CustomPair<>("1604570653.4362543", "faulted");
        i = "5a13f6bc15757813ec5aa267789cb21f706976ee30459582786383d476e7a343";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos25: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos26
        lm.setLogFile(ChaosLogFiles21to30.CHAOS26.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570743.5174744", "running");
        tsFirst = new CustomPair<>("1604570744.529898", "faulted");
        i = "f47f40bb74123d025f4fc1e9c934e1f92e54310b704fbc170f9eb42691804ef5";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos26: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos27
        lm.setLogFile(ChaosLogFiles21to30.CHAOS27.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570823.0708697", "running");
        tsFirst = new CustomPair<>("1604570824.0838425", "faulted");
        i = "4fc96f7901b171b4f4507bdfbcd8fa537d23e5fcde4cbac58dc706da790c044e";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos27: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos28
        lm.setLogFile(ChaosLogFiles21to30.CHAOS28.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570902.6735835", "running");
        tsFirst = new CustomPair<>("1604570903.676831", "faulted");
        i = "cb7742028635b72efd2b16a1ee5f40007b15286d4d8b3b69ef33e0f316535e64";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos28: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos29
        lm.setLogFile(ChaosLogFiles21to30.CHAOS29.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604570987.9989448", "running");
        tsFirst = new CustomPair<>("1604570989.0088277", "faulted");
        i = "bf39bad7354e12862dc2aa04fd1f934a230b52f98ebcb028c915d413046db28d";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos29: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");

        // Why algorithm for Chaos30
        lm.setLogFile(ChaosLogFiles21to30.CHAOS30.toString());
        lm.readLogFile();

        ts = new CustomPair<>("1604571071.2169695", "running");
        tsFirst = new CustomPair<>("1604571072.2461488", "faulted");
        i = "3e62640582f2f1f76afea604fcd60bec100ec27589f56496bab9a45682c6ec20";
        logs = LogManager.getInstance().getLogs();
        p = WhyAlgorithm.why(i, ts, tsFirst, logs, app);
        printable = gson.toJson(p);
        System.out.println("Chaos30: ");
        System.out.println(printable);

        System.out.println("--------------------------------------------------------------------------------------");
    }
}
