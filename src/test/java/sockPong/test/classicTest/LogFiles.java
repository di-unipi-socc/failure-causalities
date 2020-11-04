package sockPong.test.classicTest;

public enum LogFiles {
    ISOLATED_FAULT("/data/examples/sockPongLog/isolatedFault.log"),
    WATERFALL_FAULT("/data/examples/sockPongLog/waterfallFault.log"),
    HALF_WATERFALL_FAULT("/data/examples/sockPongLog/halfWaterfallFault.log"),
    ONE_TWO("/data/examples/sockPongLog/oneTwo.log"),
    ONE_TWO_WATERFALL("/data/examples/sockPongLog/oneTwoWaterfall.log"),
    TWO_COMPONENT_WATERFALL("/data/examples/sockPongLog/twoComponentWaterfall.log");

    private final String value;

    LogFiles(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value;
    }
}
