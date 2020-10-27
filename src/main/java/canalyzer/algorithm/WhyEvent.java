package canalyzer.algorithm;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jetbrains.annotations.NotNull;

// Represent the input event of Why
public class WhyEvent {
    // i -> instance of an event
    private @NotNull String instance = "";
    // < t , s > -> timestamp and state
    private ImmutablePair<String, String> tS;
    // < t' , s' > -> timestamp and state after event
    private ImmutablePair<String,String> tSFirst;

    public WhyEvent(@NotNull String instance,
                    ImmutablePair<String, String> firstTimeEvent,
                    ImmutablePair<String, String> secondTimeEvent) {
        this.instance = instance;
        this.tS = firstTimeEvent;
        this.tSFirst = secondTimeEvent;
    }

    public String getInstance() {
        return instance;
    }

    public ImmutablePair<String, String> gettS() {
        return tS;
    }

    public ImmutablePair<String, String> gettSFirst() {
        return tSFirst;
    }
}
