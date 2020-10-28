package canalyzer.topologies;

import canalyzer.utilities.pong.PongGenerator;
import model.Application;
import model.Node;
import model.PiVersion;
import model.StaticBinding;

import java.util.ArrayList;
import java.util.List;

public class topologyTest {
    public static void main(String[] args) {

        // Testing topology written on 21/10/2020

        // Application
        Application topologyApp = new Application("topology21-10", PiVersion.GREEDYPI);


        // Pong1
        ArrayList<String> pong1Reqs = new ArrayList<>(List.of("ping2", "ping3"));
        Node pong1 = PongGenerator.createPongNode("Pong1", pong1Reqs);
        topologyApp.addNode(pong1);

        // Pong2
        Node pong2 = PongGenerator.createPongNode("Pong2", new ArrayList<>());
        topologyApp.addNode(pong2);

        // Pong3
        ArrayList<String> pong3Reqs = new ArrayList<>(List.of("ping4"));
        Node pong3 = PongGenerator.createPongNode("Pong3", pong3Reqs);
        topologyApp.addNode(pong3);

        // Pong4
        Node pong4 = PongGenerator.createPongNode("Pong4", new ArrayList<>());
        topologyApp.addNode(pong4);

        // Pong5
        ArrayList<String> pong5Reqs = new ArrayList<>(List.of("ping3"));
        Node pong5 = PongGenerator.createPongNode("Pong5", pong5Reqs);
        topologyApp.addNode(pong5);


        // Static Binding
            // pong1 -> pong2
        StaticBinding pong1AskingPong2 = new StaticBinding("Pong1", "ping2");
        StaticBinding pong2EndPong1 = new StaticBinding("Pong2", "endpoint");
        topologyApp.addStaticBinding(pong1AskingPong2, pong2EndPong1);

            // pong1 -> pong3
        StaticBinding pong1AskingPong3 = new StaticBinding("Pong1", "ping3");
        StaticBinding pong3EndPong1 = new StaticBinding("Pong3", "endpoint");
        topologyApp.addStaticBinding(pong1AskingPong3, pong3EndPong1);

            // pong5 -> pong3
        StaticBinding pong5AskingPong3 = new StaticBinding("Pong5", "ping3");
        StaticBinding pong3EndPong5 = new StaticBinding("Pong3", "endpoint");
        topologyApp.addStaticBinding(pong5AskingPong3, pong3EndPong5);

            // pong3 -> pong4
        StaticBinding pong3AskingPong4 = new StaticBinding("Pong3", "ping4");
        StaticBinding pong4EndPong3 = new StaticBinding("Pong4", "endpoint");
        topologyApp.addStaticBinding(pong3AskingPong4, pong4EndPong3);

    }
}
