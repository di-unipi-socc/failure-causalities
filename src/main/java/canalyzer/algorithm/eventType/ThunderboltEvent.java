package canalyzer.algorithm.eventType;

import org.jetbrains.annotations.NotNull;

public class ThunderboltEvent extends WhyEvent {

    private boolean bolt;

    public ThunderboltEvent(@NotNull String instance, @NotNull String nodeName, boolean bolt) {
        super(instance, nodeName);
        this.bolt = bolt;
    }


    @Override
    public String toString() {
        return "{" +
                "instance: " + super.getInstance() +
                "nodeName:" + super.getNodeName() +
                "bolt: " + bolt +
                "}";
    }
}
