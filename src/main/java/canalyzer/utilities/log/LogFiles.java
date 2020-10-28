package canalyzer.utilities.log;

public enum LogFiles {
    ISOLATED_FAULT("/data/examples/pongLog/isolatedFault.log"),
    ONE_TWO_FAULT("/data/examples/pongLog/oneTwoFault.log"),
    WATERFALL("/data/examples/pongLog/waterfallFault.log");

    private final String value;
    LogFiles(String value){ this.value=value;}

    @Override
    public String toString(){return value;}
}
