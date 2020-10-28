package canalyzer.algorithm;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

// Represent the input event of Why
public class WhyEvent {
    // i -> instance of an event
    private @NotNull String instance;
    // < t , s > -> timestamp and state
    private ImmutablePair<String, String> tS;
    // < t' , s' > -> timestamp and state after event
    private ImmutablePair<String,String> tSFirst;
    //causes
    private ArrayList<WhyEvent> causes;

    public WhyEvent(@NotNull String instance,
                    ImmutablePair<String, String> firstTimeEvent,
                    ImmutablePair<String, String> secondTimeEvent) {
        this.instance = instance;
        this.tS = firstTimeEvent;
        this.tSFirst = secondTimeEvent;
        this.causes = new ArrayList<>();
    }

    public @NotNull String getInstance() {
        return instance;
    }

    public ImmutablePair<String, String> gettS() {
        return tS;
    }

    public ImmutablePair<String, String> gettSFirst() {
        return tSFirst;
    }

    public void addCause(WhyEvent e){
        causes.add(e);
    }

    public ArrayList<WhyEvent> getCauses() {
        return causes;
    }
}
