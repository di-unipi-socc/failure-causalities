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

Step by step command and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop Edge_Router_Container
    - Stops Edge Router

Other Containers remain up.

--- 
###onwTwo.log
Step by step command and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop Frontend_Software_Container
    - Stop Frontend container
    - Edge router receives an error and passes from running state to faulted state

Other containers remain up. 

---
###oneTwoWaterfall.log
Step by step command and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop Orders_Software
    - Frontend then Edge_Router receive error and passes from running to faulted
- Docker stop Users_DB_Container
    - Users_Software receives an error and passes in faulted state
    - No other container receives error because they are already in faulted state
 
---
###twoComponentWaterfall.log
Step by step command and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop Users_DB_Container and Docker stop Carts_DB_Container
    - Users_Software and Carts_Software receive error and pass from running state to faulted state
    - Then both Frontend and Orders_Software receive the same error and pass in faulted state
    - Finally, also Edge_Router passes from running to faulted 

Other containers remain up.

---