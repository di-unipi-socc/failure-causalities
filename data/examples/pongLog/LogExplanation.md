# Log Explanation

###waterfallFault.log
This file contains log from Pong application and shows an example of waterfall
fault.   
Step by step commands and their consequences:
- Docker compose up (equivalent of Docker start)
    - Starts all containers
- Docker stop pong4
    - Stops pong4
    - pong3 receive an error and passes from running state to faulted state
    - pong5 same as pong3
    - pong1 same as pong3 and pong5  

The only container that remains in running state is pong2.  

---
###oneTwoFault.log
This file contains log from Pong application, shows how stopping pong2 only pong1  
goes down.  
Step by step commands and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop pong2
    - Stops pong2
    - pong1 receives an error and passes from running state to faulted state
    - others container remain in running state  
    
Only pong1 passes from running to faulted because it has no more one requirement that  
gives to him pong2.  

---
###isolatedFault.log
This file contains log from Pong application, shows how stopping pong5 no  
other container passes through fault state.  
Step by step commands and their consequences:
- Docker compose up
    - Starts all containers
- Docker stop pong5
    - Stops pong5
    - no other container pass from running state to faulted state  
    
No other container pass from running to faulted state because no one have through  
his requirements the capability of pong5

--- 