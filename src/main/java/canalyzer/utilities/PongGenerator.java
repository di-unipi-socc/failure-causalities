package canalyzer.utilities;


import model.Node;
import model.ManagementProtocol;

import java.util.ArrayList;

public class PongGenerator {

    public static model.Node createPongManagementProtocol(ArrayList<model.Requirement> requirements){
        Node pongNode = new Node("pong", "not-available", new ManagementProtocol());
        ManagementProtocol pongMP = pongNode.getManagementProtocol();

        pongNode.addState("not-available");
        pongNode.addState("running");
        pongNode.addState("faulted");
        pongNode.addState("stopped");

        pongNode.addCapability("endpoint");

        pongNode.addOperation("run");
        pongNode.addOperation("start");
        pongNode.addOperation("stop");
        pongNode.addOperation("delete");

        pongMP.addTransition("not-available", "run", "running");
        pongMP.addTransition("running", "stop", "stopped");
        pongMP.addTransition("stopped", "start", "running");
        pongMP.addTransition("faulted", "stop", "stopped");
        pongMP.addTransition("stopped", "delete", "not-available");

        //TODO finire di scrivere le cose che mancano


        return pongNode;
    }
}
