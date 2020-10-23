package canalyzer.utilities;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class PongGenerator {

    public static Node createPongManagementProtocol(String name , ArrayList<String> requirements) {
        Node pongNode = new Node(name, PongState.NAVAIL.toString(), new ManagementProtocol());
        ManagementProtocol pongMP = pongNode.getManagementProtocol();

        // States
        pongNode.addState(PongState.NAVAIL.toString());
        pongNode.addState(PongState.RUNNING.toString());
        pongNode.addState(PongState.FAULTED.toString());
        pongNode.addState(PongState.STOPPED.toString());

        // Capability
        pongNode.addCapability("endpoint");

        // Operations
        pongNode.addOperation(PongOperations.RUN.toString());
        pongNode.addOperation(PongOperations.START.toString());
        pongNode.addOperation(PongOperations.STOP.toString());
        pongNode.addOperation(PongOperations.DELETE.toString());

        // Requirements
        for ( String req : requirements) {
            pongNode.addRequirement(new Requirement(req, RequirementSort.REPLICA_UNAWARE));
        }

        // Transaction
        pongMP.addTransition(PongState.NAVAIL.toString(), PongOperations.RUN.toString(), PongState.RUNNING.toString());
        pongMP.addTransition(PongState.RUNNING.toString(), PongOperations.STOP.toString(), PongState.STOPPED.toString());
        pongMP.addTransition(PongState.STOPPED.toString(), PongOperations.START.toString(), PongState.RUNNING.toString());
        pongMP.addTransition(PongState.FAULTED.toString(), PongOperations.STOP.toString(), PongState.STOPPED.toString());
        pongMP.addTransition(PongState.STOPPED.toString(), PongOperations.DELETE.toString(), PongState.NAVAIL.toString());

        // Rho : state -> reqs
        for (String state : pongNode.getStates()) {
            pongMP.addRhoEntry(state, new ArrayList<>());
        }
        pongMP.addRhoEntry(PongState.RUNNING.toString(), pongNode.getReqs());

        // Gamma : state -> caps offered
        for (String state : pongNode.getStates()) {
            pongMP.addGammaEntry(state, new ArrayList<>());
        }
        List<String> runningCaps = new ArrayList<>();
        runningCaps.add("endpoint");
        pongMP.addGammaEntry(PongState.RUNNING.toString(), runningCaps);

        // Phi : state -> list of states for fault handling
        for (String state : pongNode.getStates()) {
            pongMP.addPhiEntry(state, new ArrayList<>());
        }
        List<String> runningFaultHand = new ArrayList<>();
        runningFaultHand.add(PongState.FAULTED.toString());
        pongMP.addPhiEntry(PongState.RUNNING.toString(), runningFaultHand);

        return pongNode;
    }
}
