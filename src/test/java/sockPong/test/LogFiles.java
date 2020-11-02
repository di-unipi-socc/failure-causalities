package sockPong.test;

public enum LogFiles {
    ISOLATED_FAULT("/data/examples/sockPongLog/isolatedFault.log"),
    WATERFALL_FAULT("/data/examples/sockPongLog/waterfallFault.log"),
    HALF_WATERFALL_FAULT("/data/examples/sockPongLog/halfWaterfallFault.log");

    private final String value;

    LogFiles(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
