package canalyzer.utilities.pong;

public enum PongState {
    NAVAIL("not-avilable"),
    RUNNING("running"),
    FAULTED("faulted"),
    STOPPED("stopped");

    private final String value;
    PongState(String value){
        this.value=value;
    }

    @Override
    public String toString(){
        return value.toLowerCase();
    }
}
