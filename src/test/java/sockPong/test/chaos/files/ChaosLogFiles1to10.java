package sockPong.test.chaos.files;

public enum ChaosLogFiles1to10 {

    CHAOS1("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos1.log"),
    CHAOS2("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos2.log"),
    CHAOS3("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos3.log"),
    CHAOS4("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos4.log"),
    CHAOS5("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos5.log"),
    CHAOS6("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos6.log"),
    CHAOS7("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos7.log"),
    CHAOS8("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos8.log"),
    CHAOS9("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos9.log"),
    CHAOS10("/data/examples/chaosTesting/chaosLog/chaos1-10/chaos10.log");

    private final String value;

    ChaosLogFiles1to10(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
