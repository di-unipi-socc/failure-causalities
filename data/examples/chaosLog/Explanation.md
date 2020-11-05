##Explanation of chaosLog folder
In this directory there are files generated by a Chaos Monkey script.
Let's analyze what it does:
- Firs of all, it creates all containers of SockPong Topology, executing a docker-compose up command
- Then it chooses a sub-set (killableContainers) of them, except for Edge_router
- It lets them exchange messages for a bunch of seconds
- After that it stops all the containers inside the sub-set
- Then it lets the other containers fault, if they have to
- Last executes a docker-compose down command

All the files inside this folder are generated in this way.