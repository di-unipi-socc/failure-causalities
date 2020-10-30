package canalyzer.utilities.log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

// Singleton that reads log files and returns al object with the elements read
public class LogManager {

    // Static variable that represents the single instance of the class
    private static volatile LogManager single_instance = null;
    // Log file name
    private @NotNull String logFileName = "";
    // After reading files it contains logs
    private Hashtable<String, ArrayList<LogFormat>> logs;

    public static LogManager getInstance() {
        // Check if there is only one instance of the class
        if (single_instance == null) {
            synchronized (LogManager.class) {
                if (single_instance == null) {
                    single_instance = new LogManager();
                }
            }
        }
        return single_instance;
    }

    private LogManager() {
        this.logs = new Hashtable<>();
    }


    /**
     * If no error occurred set the log file path
     * @param logFile name of the file inside resources/PongLog to read
     * @return set the name of the file, and return true if the name isn't settled before,
     * don't set the name and return false otherwise
     */
    public synchronized boolean setLogFile(@NotNull String logFile) {
        if (!logFile.isBlank()) {
            logFileName = System.getProperty("user.dir") + logFile;
            return true;
        }
        return false;
    }


    /**
     * Reads from a settled log file and populates private fields
     * @return ture if no error occurred, false otherwise
     */
    public synchronized boolean readLogFile() {
        if (!logFileName.isBlank()) {
            // Initialize Gson to read json elements
            Gson gson = new Gson();
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(logFileName));
                String line = reader.readLine();
                while (line != null) {
                    Type typeLogFormat = new TypeToken<LogFormat>() {}.getType();
                    // Read each element from log file
                    LogFormat elem = gson.fromJson(line, typeLogFormat);

                    // Check if the key is present, otherwise initializes his log
                    // element ArrayList and insert the first one
                    ArrayList<LogFormat> tmp = logs.get(elem.getNodeId());
                    if (tmp != null) {
                        tmp.add(elem);
                    } else {
                        tmp = new ArrayList<>();
                        tmp.add(elem);
                        logs.put(elem.getNodeId(), tmp);
                    }

                    // Read the next element
                    line = reader.readLine();
                }

                // For each element inside the Hashtable sort his list of LogFormat
                logs.forEach((node_id , nodeLogs) -> Collections.sort(nodeLogs));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                logs = new Hashtable<>();
                return false;
            }
        }
        return false;
    }

    /**
     * Returns the logs previously read
     * @return the private field of the singleton
     */
    public synchronized Hashtable<String, ArrayList<LogFormat>> getLogs(){
        return logs;
    }

    /**
     * Returns the list of nodeId whose name is nodeName
     * @param nodeName name of the node to search inside the logs
     * @return ArrayList with nodeId
     */
    public synchronized ArrayList<String> getNodeIdListByNodeName(String nodeName){
        ArrayList<String> result = new ArrayList<>();
        logs.forEach((nodeId, logList) ->{
            LogFormat tmp = logList.get(0);
            if (tmp.getNodeName().equals(nodeName)){
                result.add(nodeId);
            }
        });
        return result;
    }

    /**
     * Returns the list of nodeContainerId whose name is nodeName and nodeId is i
     * @param nodeName name of the node
     * @param i id of the node
     * @return ArrayList with nodeContainerId
     */
    public synchronized ArrayList<String> getNodeContainerIdByNodeNameNodeId(String nodeName, String i){
        ArrayList<String> result = new ArrayList<>();
        logs.forEach((nodeId, logList) -> {
            LogFormat tmp = logList.get(0);
            if(tmp.getNodeName().equals(nodeName) && tmp.getNodeId().equals(i)){
                result.add(tmp.getNodeContainerId());
            }
        });
        return result;
    }

    /**
     * Returns the list of log in which j is or nodeId or nodeContainerId
     * @param j nodeId or nodeContainerId
     * @return ArrayList with logs
     */
    public synchronized ArrayList<LogFormat> getLogsByNodeIdOrNodeContainerId(String j){
        ArrayList<LogFormat> result = logs.get(j);
        if(result != null){
            return result;
        }
        ArrayList<LogFormat> finalResult = new ArrayList<>();
        logs.forEach((nodeId, logList) ->{
            ArrayList<LogFormat> tmp = new ArrayList<>(logList);
            tmp.removeIf( el -> el.getNodeContainerId().equals(j));
            finalResult.addAll(tmp);
        });
        Collections.sort(finalResult);
        return finalResult;
    }
}
