package canalyzer.algorithm;

import java.util.ArrayList;

public class CausalityGraph {
    private WhyEvent root;

    public CausalityGraph(WhyEvent root) {
        this.root = root;
    }

    public WhyEvent getEventToBeExplained(){
        return root;
    }

    private void why(){
        //richiami l'algoritmo (?)
    }

    private void printCausalities(){
        //stampa il grafo delle causalita' (?)
    }
}
