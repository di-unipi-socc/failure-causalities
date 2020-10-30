package canalyzer.algorithm.eventType;

import canalyzer.algorithm.CustomPair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

// Represent the input event of Why
public abstract class WhyEvent {

    // i -> instance of an event
    private @NotNull String instance;
    private @NotNull String nodeName;


    public WhyEvent(@NotNull String instance, @NotNull String nodeName) {
        this.instance = instance;
        this.nodeName = nodeName;
    }

    public @NotNull String getInstance() {
        return instance;
    }

    public @NotNull String getNodeName() {
        return nodeName;
    }

    @Override
    public abstract String toString();

}
