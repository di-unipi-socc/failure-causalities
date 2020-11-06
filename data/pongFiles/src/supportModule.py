from enum import Enum
import threading
import time

# States in which the app can be found
class appState(Enum):
    notAvailable = "notAvailable"
    running = "running"
    faulted = "faulted"
    stopped = "stopped"

class logLabel(Enum):
    fault = "fault"
    state = "state"
    operation = "operation"
    other = "other"


# Implement the lock between threads resources
def synchronized(func):

    func.__lock__ = threading.Lock()

    def synced_func(*args, **kws):
        with func.__lock__:
            return func(*args, **kws)

    return synced_func
