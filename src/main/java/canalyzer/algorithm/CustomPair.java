package canalyzer.algorithm;

public class CustomPair<L,R> {
    private L _time;
    private R _info;

    public CustomPair() {
    }

    public CustomPair(L _time, R _info) {
        this._time = _time;
        this._info = _info;
    }

    public L get_time() {
        return _time;
    }


    public R get_info() {
        return _info;
    }

    public void set_info(R _info) {
        this._info = _info;
    }

    public void setAll(L left, R right){
        this._time = left;
        this._info = right;
    }

    @Override
    public String toString() {
        return "{" +
                "time=" + _time +
                ", info=" + _info +
                '}';
    }
}
