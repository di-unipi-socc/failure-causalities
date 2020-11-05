package sockPong.test.chaos.files;

public enum ChaosLogFiles21to30 {
    CHAOS21("/data/examples/chaosLog/chaos21-30/chaos21.log"),
    CHAOS22("/data/examples/chaosLog/chaos21-30/chaos22.log"),
    CHAOS23("/data/examples/chaosLog/chaos21-30/chaos23.log"),
    CHAOS24("/data/examples/chaosLog/chaos21-30/chaos24.log"),
    CHAOS25("/data/examples/chaosLog/chaos21-30/chaos25.log"),
    CHAOS26("/data/examples/chaosLog/chaos21-30/chaos26.log"),
    CHAOS27("/data/examples/chaosLog/chaos21-30/chaos27.log"),
    CHAOS28("/data/examples/chaosLog/chaos21-30/chaos28.log"),
    CHAOS29("/data/examples/chaosLog/chaos21-30/chaos29.log"),
    CHAOS30("/data/examples/chaosLog/chaos21-30/chaos30.log");

    private final String value;

    ChaosLogFiles21to30(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
