# Example Log Files
The example log files in this folder have been stored while running instances of the ([SockPong](https://github.com/di-unipi-socc/failure-causalities/blob/main/data/docker-composeSockPong.yml)) application. The application is essentially obtained by replacing each service in [SockShop](https://github.com/microservices-demo/microservices-demo) with a containerized [Pong](https://github.com/di-unipi-socc/failure-causalities/tree/main/data/pongFiles/src) service.

The different log files correspond to different cases of (cascading) failures, which we explain hereafter. In 

### Stopping a Single Application Component  
The file `isolatedFault.log` contains the application logs stored by running an instance of  SockPong as follows:
* `docker compose up`: to start all the application's containers;
* `docker stop Edge_Router_Container`: to stop the instance of Edge Router.

The stop of Edge Router is logged at time `1604239008.8466222`. 

If we exploit the library to explain what happened to Edge Router, we obtain that the library successfully tells us that the `stop` operation was invoked on Edge Router (whose stop was hence not due to any failure).

### Failing Service Instance due to Stopping Another Service Instance
The file `oneTwo.log` contains the application logs stored by running an instance of  SockPong as follows:
* `docker compose up`: to start all the application's containers;
* `docker stop Frontend_Software_Container`: to stop the instance of Frontend, hence causing a failure in Edge Router.

The failure of Edge Router is logged at time `1604398053.60538`.

If we exploit the library to explain what happened to Edge Router, we obtain that the library successfully tells us that Edge Router may have failed because of the `stop` of Frontend.

### Failure Cascades due to Stopping a Service Instance
The file `waterfallFault.log` contains the application logs stored by running an instance of  SockPong as follows:
* `docker compose up`: to start all the application's containers;
* `docker stop Carts_DB_Container`: to stop the instance of Carts DB, hence causing cascading failures in the service instances depending on Carts DB, in those depending on such instances, and so on, until the instance of Edge Router also fails.

The failure of Edge Router is logged at time `1604252061.741119`.

If we exploit the library to explain what happened to Edge Router, we obtain that the library successfully visualise the cascading failures due to the `stop` of Carts DB, which may have caused the logged failure of Edge Router.

NB: The file `halfWaterfallFault.log` contains the application logs stored by running an instance of SockPong in a similar case (in which the cascading failures were caused by a stop of Orders DB, rather than by the stop of Carts DB).

### Failure Cascades due to Stopping two Different Service Instances

#### Subsequent Failure Cascades 
The file `oneTwoWaterfall.log` contains the application logs stored by running an instance of  SockPong as follows:
* `docker compose up`: to start all the application's containers;
* `docker stop Orders_Software`: to stop the instance of Orders, hence causing cascading failures in the service instances depending on Carts DB, in those depending on such instances, and so on, until the instance of Edge Router also fails.
* `docker stop Users_DB_Container`: to stop the instance of Users DB, hence causing cascading failures (which do not propagate to Orders, Frontend, and Edge Router, as they are already stopped/failed).

The failure of Edge Router is logged at time `1604400140.4041817`.

If we exploit the library to explain what happened to Edge Router, we obtain that the library successfully visualise the cascading failures due to the `stop` of Orders, which may have caused the logged failure of Edge Router. The `stop` of Users DB is instead not considered as a possible cause for the failure of Edge Router.

#### Parallel Failure Cascades 
The file `twoComponentWaterfall.log` contains the application logs stored by running an instance of  SockPong as follows:
* `docker compose up`: to start all the application's containers;
* `docker stop Users_DB_Container Carts_DB_Container`: to simultaneously stop the instances of Users DB and Carts DB, hence causing failure cascades propagating in parallel, and both possibly causing the monitored failure of Edge Router.

The failure of Edge Router is logged at time `1604400281.0757217`.

If we exploit the library to explain what happened to Edge Router, we obtain that the library successfully visualise the cascading failures due to the `stop` of Users DB and Carts DB, which may both have caused the logged failure of Edge Router.