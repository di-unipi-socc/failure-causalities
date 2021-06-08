# A Java Library for Explaining Failure Causalities
This repository provides a Java-based library for identifying the possible causes for a failure to happen in a multi-service application, based on the offline analysis the logs stored while the application was running.

## Using the Library

### Input Logs
The library can analyse application logs structured in [GELF](https://docs.graylog.org/), which must include the following fields:

* `nodeName`: name of the service whose instance is logging an event,
* `nodeID`: identifier of the instance of the service logging an event,
* `timestamp`: time when an event has been logged, 
* `label`: type of logged event (residing in a `state`, executing an `operation`, or experiencing a `failure`), and 
* `info`: additional information on the logged event (e.g., the name of state or operation being executed, or the printout of the failure information).

### Coding in Java 

A prerequisite for exploiting the library is to specify the structure and management behaviour of the application must be represented with the Java-based object model for [management-protocols](https://github.com/di-unipi-socc/management-protocols).
This enables obtaining an [`Application`](https://github.com/di-unipi-socc/management-protocols/blob/master/replica-aware-mprot/src/main/java/mprot/core/model/Application.java) object, which can be given as input to the core method [`WhyAlgorithm.why`](https://github.com/di-unipi-socc/failure-causalities/blob/ed6b2b8d348ed7fb13565230a4e570f7feb6e2ee/src/main/java/canalyzer/algorithm/WhyAlgorithm.java#L29), which actually runs the analysis.

The method [`WhyAlgorithm.why`](https://github.com/di-unipi-socc/failure-causalities/blob/ed6b2b8d348ed7fb13565230a4e570f7feb6e2ee/src/main/java/canalyzer/algorithm/WhyAlgorithm.java#L29) also inputs the application logs to be analysed, which are to be provided by instantiating a [`LogManager`](https://github.com/di-unipi-socc/failure-causalities/blob/main/src/main/java/canalyzer/utilities/log/LogManager.java). The latter offers a constructor enabling to specify the path to the log file to be analysed.

Running the analysis then just requires to invoke the core method [`WhyAlgorithm.why`](https://github.com/di-unipi-socc/failure-causalities/blob/ed6b2b8d348ed7fb13565230a4e570f7feb6e2ee/src/main/java/canalyzer/algorithm/WhyAlgorithm.java#L29), by passing it the [`Application`](https://github.com/di-unipi-socc/management-protocols/blob/master/replica-aware-mprot/src/main/java/mprot/core/model/Application.java) specification, the [`LogManager`](https://github.com/di-unipi-socc/failure-causalities/blob/main/src/main/java/canalyzer/utilities/log/LogManager.java), and the event to be explained (in the form of `CustomPair`s).

As a result, we obtain a causality graph modelling all events that may have possibly caused the event to be explained. More precisely, the core method [`WhyAlgorithm.why`](https://github.com/di-unipi-socc/failure-causalities/blob/ed6b2b8d348ed7fb13565230a4e570f7feb6e2ee/src/main/java/canalyzer/algorithm/WhyAlgorithm.java#L29) returns a `WhyEvent`, which corresponds to the node in the causality graph modelling event to be explained. Each `WhyEvent` also includes 
* references to the `WhyEvent`s that may have possibly caused it, to enable to recursively visit the graph, and
* a `toString` method, which printouts the causality graph in a JSON format.

## Examples
This repository includes a reference, Docker-based application ([SockPong](https://github.com/di-unipi-socc/failure-causalities/blob/main/data/docker-composeSockPong.yml)) to generate application logs that can be processed by the library, as well as [examples of application logs](https://github.com/di-unipi-socc/failure-causalities/tree/main/data/examples/sockPongLog) and of Java [runnable classes](https://github.com/di-unipi-socc/failure-causalities/tree/main/src/test/java/sockPong/test/classicTest) to visualise the causes of the failures contained in there.

This repository also includes all what needed to run chaos testing on the library, still based on the reference application. In particular, the repository includes a [Python script](https://github.com/di-unipi-socc/failure-causalities/blob/main/data/examples/chaosTesting/monkey/chaos.py) for running a chaos test, examples of [application logs](https://github.com/di-unipi-socc/failure-causalities/tree/main/data/examples/chaosTesting/chaosLog) obtained with such script, and the Java [runnable class](https://github.com/di-unipi-socc/failure-causalities/tree/main/src/test/java/sockPong/test/chaos) to analyse such example logs.

## About 
The algorithm implemented by this library was first presented in 
> J. Soldani, G. Montesano, A. Brogi. 
> **What Went Wrong? Explaining Cascading Failures in Microservice-based Applications**. 
> 15th Symposium and Summer School On  Service-Oriented Computing (SummerSOC 2021), _accepted for publication_.

If you wish to reuse the library or its sources, please properly cite the above mentioned paper. Below you can please find the BibTex reference:
```
TBA
```

