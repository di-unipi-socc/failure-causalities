package canalyzer.topologies;

import canalyzer.utilities.PongGenerator;
import model.Application;
import model.Node;
import model.PiVersion;
import model.StaticBinding;

import java.util.ArrayList;
import java.util.List;

public class topologyTest {
    public static void main(String[] args) {

        // Testing topology written on 21/10/2020

        // Pong1
        ArrayList<String> pong1Reqs = new ArrayList<>(List.of("ping2", "ping3"));
        Node pong1 = PongGenerator.createPongManagementProtocol("pong1", pong1Reqs);

        // Pong2
        Node pong2 = PongGenerator.createPongManagementProtocol("pong2", new ArrayList<>());

        // Pong3
        ArrayList<String> pong3Reqs = new ArrayList<>(List.of("ping4"));
        Node pong3 = PongGenerator.createPongManagementProtocol("pong3", pong3Reqs);

        // Pong4
        Node pong4 = PongGenerator.createPongManagementProtocol("pong4", new ArrayList<>());

        // Pong5
        ArrayList<String> pong5Reqs = new ArrayList<>(List.of("ping3"));
        Node pong5 = PongGenerator.createPongManagementProtocol("pong5", pong5Reqs);

        // Application
        Application topologyApp = new Application("topology21-10", PiVersion.GREEDYPI);

        // Static Binding
            // pong1 -> pong2
        StaticBinding pong1AskingPong2 = new StaticBinding("pong1", "endpoint");
        StaticBinding pong2EndPong1 = new StaticBinding("pong2", "endpoint");
        topologyApp.addStaticBinding(pong1AskingPong2, pong2EndPong1);

            // pong1 -> pong3
        StaticBinding pong1AskingPong3 = new StaticBinding("pong1", "endpoint");
        StaticBinding pong3EndPong1 = new StaticBinding("pong3", "endpoint");
        topologyApp.addStaticBinding(pong1AskingPong3, pong3EndPong1);

            // pong5 -> pong3
        StaticBinding pong5AskingPong3 = new StaticBinding("pong5", "endpoint");
        StaticBinding pong3EndPong5 = new StaticBinding("pong3", "endpoint");
        topologyApp.addStaticBinding(pong5AskingPong3, pong3EndPong5);

            // pong3 -> pong4
        StaticBinding pong3AskingPong4 = new StaticBinding("pong3", "endpoint");
        StaticBinding pong4EndPong3 = new StaticBinding("pong4", "endpoint");
        topologyApp.addStaticBinding(pong3AskingPong4, pong4EndPong3);

    }
}
