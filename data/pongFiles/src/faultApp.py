from flask import Flask
from flask_restful import Resource, Api
from threading import *
import requests , json , os , sys , logging , signal, random
from time import sleep
from supportModule import *
from gelfformatter import GelfFormatter


# Global variables
app = Flask(__name__)
api = Api(app)
state = appState.notAvailable
# ------------------------------------------------------------------------------------------------

# Suppress log not send by this application but from imported library
logging.getLogger('werkzeug').disabled = True
for i in logging.Logger.manager.loggerDict :
    logging.getLogger(i).disabled = True

# Sets GELF as logging format
formatter = GelfFormatter()
hd = logging.StreamHandler(sys.stdout)
hd.setFormatter(formatter)
logging.basicConfig(level=logging.DEBUG, handlers=[hd])

# ------------------------------------------------------------------------------------------------

# Environment variables
containerName = os.environ['NAME']
linking = []
try:
    linking = os.environ["LINKING"].split(',')
except KeyError:
    # No connection with other container
    pass

# ------------------------------------------------------------------------------------------------

# Function to modify state variable without race condition


@synchronized
def changeState(newState):
    global state
    state = newState

# ------------------------------------------------------------------------------------------------

# Catch SIGTERM to change state, log it and close the entire application


def signal_handler(signal, frame):
    changeState(appState.stopped)
    sleep(0.2)
    logging.critical("SIGTERM arrived, closing app", extra={"label": logLabel.operation.value , "info": "stop" })
    sys.exit(0)

# ------------------------------------------------------------------------------------------------

# Simple class to answer the GET method
class Ping(Resource):
    # GET
    def get(self):
        tmp = None
        if state is appState.running:
            tmp = {'Pong': containerName}, 200
            logging.info("Positive response", extra={
                         "label": logLabel.state.value, "info": state.value})
        else:
            tmp = {'Error': containerName}, 500
            logging.error("Response with error", extra={
                         "label": logLabel.state.value, "info": state.value})
        return tmp

# ------------------------------------------------------------------------------------------------
# ------------------------------------------------------------------------------------------------

# Class used to send GET request to other linked container. Registers every event happened


class GetSender(Thread):
    def run(self):
        global state
        # If the service has at least one link
        if len(linking) != 0:
            while state is appState.running:
                sleep(1)
                try:
                    # For each other service linked to this one
                    for l in linking:
                        r = requests.get("http://"+l+":5000/")
                        if r.status_code >= 400:
                            changeState(appState.faulted)
                            logging.error("Request failed", extra={
                                "label": logLabel.fault.value, "info": "Error from " + l})
                            break
                        else:
                            logging.info("Request successful from " + l, extra= {
                                "label": logLabel.state.value, "info": appState.running.value})
                except Exception as exp:
                    changeState(appState.faulted)
                    logging.error("Error occurred...", extra={
                        "label": logLabel.fault.value, "info": "Exception: " + type(exp).__name__})
            # Shutdown the thread if error occurred with other services, the process stays alieve
        return


# ------------------------------------------------------------------------------------------------
# ------------------------------------------------------------------------------------------------


api.add_resource(Ping, '/')

# ------------------------------------------------------------------------------------------------


if __name__ == "__main__":
    changeState(appState.running)
    signal.signal(signal.SIGTERM, signal_handler)

    logging.info("Application started", extra={
                 "label": logLabel.operation.value, "info": "start"})

    # Spawns a thread that send Get Request to other services
    GetSender().start()

    app.run(host='0.0.0.0')
