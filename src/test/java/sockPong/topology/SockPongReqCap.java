package sockPong.topology;

public enum SockPongReqCap {
    CONN("conn"),
    ENDP("endpoint");

    private final  String value;
    SockPongReqCap(String value){
        this.value=value;
    }

    @Override
    public String toString(){ return value;}
}
