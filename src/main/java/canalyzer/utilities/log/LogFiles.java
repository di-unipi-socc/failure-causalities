package canalyzer.utilities.log;

public enum LogFiles {
    ISOLATED_FAULT("isolatedFault.log"),
    ONE_TWO_FAULT("oneTwoFault.log"),
    WATERFALL("waterfall");

    private final String value;
    LogFiles(String value){ this.value=value;}

    @Override
    public String toString(){return value;}
}
