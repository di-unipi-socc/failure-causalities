package canalyzer.algorithm;

import java.util.ArrayList;

public class CausalityGraph {
    private ArrayList<WhyEvent> events;
    private ArrayList<WhyCausality> causalities;

    public CausalityGraph(ArrayList<WhyEvent> events, ArrayList<WhyCausality> causalities) {
        this.events = events;
        this.causalities = causalities;
    }
}
