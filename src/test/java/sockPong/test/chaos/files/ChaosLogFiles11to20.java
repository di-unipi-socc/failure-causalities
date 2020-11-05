package sockPong.test.chaos.files;

public enum ChaosLogFiles11to20 {
    CHAOS11("/data/examples/chaosLog/chaos11-20/chaos11.log"),
    CHAOS12("/data/examples/chaosLog/chaos11-20/chaos12.log"),
    CHAOS13("/data/examples/chaosLog/chaos11-20/chaos13.log"),
    CHAOS14("/data/examples/chaosLog/chaos11-20/chaos14.log"),
    CHAOS15("/data/examples/chaosLog/chaos11-20/chaos15.log"),
    CHAOS16("/data/examples/chaosLog/chaos11-20/chaos16.log"),
    CHAOS17("/data/examples/chaosLog/chaos11-20/chaos17.log"),
    CHAOS18("/data/examples/chaosLog/chaos11-20/chaos18.log"),
    CHAOS19("/data/examples/chaosLog/chaos11-20/chaos19.log"),
    CHAOS20("/data/examples/chaosLog/chaos11-20/chaos20.log");

    private final String value;

    ChaosLogFiles11to20(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
