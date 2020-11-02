# Log Explanation
In these files there are logs from sockPong application. This app was made by replacing
each node of [SockShop](http://pages.di.unipi.it/soldani/assets/preprints/tosker-extended.pdf) 's topology
with Pong node to generate eventually waterfall errors.

###waterfallFault.log  

Step by step commands and their consequences:
- Docker compose up (equivalent of Docker start)
    - Starts all containers
- Docker stop Carts_DB_Container
    - Stops Carts_DB_Container
    - Carts_Software receives an error and passes from running state to faulted state
    - Orders and Fronted Software receive an error like Carts_Software
    - The last one receives and error is Edge_Router because Frontend passed from running to faulted, so its does the same

All the other containers remain in running state.

---
###halfWaterfallFault.log

Step by step command and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop Orders_DB_Container
    - Stops Orders_DB_Container
    - Orders_Software receives an error and passes from running state to faulted state
    - Frontend_Software and Edge_Router_container same as Orders_Software
    
Other Containers remain up.

---
###isolatedFault.log

Step by step command and theri consequences:
- Docker compose up
    - Starts all containers
- Docker stop Edge_Router_Container
    - Stops Edge Router

Other Containers remain up.

--- 