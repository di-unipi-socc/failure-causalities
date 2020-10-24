package canalyzer.utilities.log;

import java.util.ArrayList;
import java.util.HashMap;

// Singleton that reads log files and returns al object with the elements read
public class LogManager {

    // Static variable that represents the single instance of the class
    private static volatile LogManager single_instance = null;
    // Log file name
    private String logFileName = null;
    // After reading files it contains logs
    private HashMap<String, ArrayList<LogFormat>> logs;

    public static LogManager getInstance(){
        // Check if there is only one instance of the class
        if(single_instance == null) {
            synchronized ( LogManager.class) {
                if (single_instance == null){
                    single_instance = new LogManager();
                }
            }
        }
        return single_instance;
    }

    private LogManager(){
        this.logs = new HashMap<>();

    }


    /**
     * @param logFile name of the file inside resources/PongLog to read
     * @return set the name of the file, and return true if the name isn't settled before,
     *         don't set the name and return false otherwise
     */
    public synchronized boolean setLogFile(String logFile){
        if(logFileName == null){
            String logFolder = System.getProperty("user.dir") + "src/main/resources/pongLog/";
            if(logFile == null){
                return false;
            }
            else
                logFileName = logFolder + logFile;
            return true;
        }
        else
            return false;
    }
}
