import docker
import subprocess
import random
from time import sleep

# Docker compose file name
dockerComposeFile = "../../../docker-composeSockPong.yml"

if __name__ == "__main__":

    # Start docker containers
    print("Creating containers...")
    subprocess.call(["docker-compose", "-f", dockerComposeFile, "up", "-d", "--build"],
                    stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
    # subprocess.call(["ls"])
    print("Containers created")

    # Takes client configuration from environment variables
    client = docker.from_env()

    # Extracts running container except for Edge_Router
    killableContainers = [x for x in client.containers.list() if x.name != "Edge_Router" and x.name != "Logstash"]
    edge_router = [x for x in client.containers.list() if x.name == "Edge_Router"]

    # Creates a sub-set of container to be killed
    subSetSize = random.randint(1, len(killableContainers) - 3)
    subSet = random.sample(killableContainers, subSetSize)
    print("Waiting 15 seconds before the chaos...")
    print("Edge_Router nodeId: " + edge_router[0].id)
    sleep(15)

    # Kills sub set of containers
    for container in subSet:
        container.stop()

    print("Stopped containers:")
    for item in subSet:
        print("- " + item.name)

    print("Let the errors flow a bit...")
    sleep(10)
    print("Removing all containers...")
    subprocess.call(["docker-compose", "-f", dockerComposeFile, "down"], stdout=subprocess.DEVNULL,
                    stderr=subprocess.DEVNULL)
    print("Chaos ended")
