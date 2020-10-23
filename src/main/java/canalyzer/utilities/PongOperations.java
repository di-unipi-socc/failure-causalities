package canalyzer.utilities;

public enum PongOperations {
    RUN("run"),
    START("start"),
    STOP("stop"),
    DELETE("delete");

    private final String value;
    PongOperations(String value) { this.value = value;}

    @Override
    public String toString(){ return value.toLowerCase();}
}
