package canalyzer.algorithm;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jetbrains.annotations.NotNull;

// Represent the input causality of Why
public class WhyCausality {

    // i -> instante
    private @NotNull String i;
    // < t , x > -> timestamp and state
    private ImmutablePair<String, String> tX;
    // < t' , x' > -> timestamp and state
    private ImmutablePair<String, String> tXFirst;
    // < i , <t,s> , <t',s'> > -> event
    private WhyEvent event;

    public WhyCausality(@NotNull String i,
                        ImmutablePair<String, String> tX,
                        ImmutablePair<String, String> tXFirst,
                        WhyEvent event) {
        this.i = i;
        this.tX = tX;
        this.tXFirst = tXFirst;
        this.event = event;
    }

}
