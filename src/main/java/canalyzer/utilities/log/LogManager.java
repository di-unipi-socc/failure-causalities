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
            String baseDirPath = System.getProperty("user.dir");
            logFileName = baseDirPath + logFile;
            return true;
        }
        return false;
    }


    /**
     * Read from a settled log file and populates private fields
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
                    Type typeLogFormat = new TypeToken<LogFormat>() {
                    }.getType();
                    // Read each element from log file
                    LogFormat elem = gson.fromJson(line, typeLogFormat);

                    // Check if the key is present, otherwise initializes his log
                    // element ArrayList and insert the first one
                    ArrayList<LogFormat> tmp = logs.get(elem.getContainer_id());
                    if (tmp != null) {
                        tmp.add(elem);
                    } else {
                        tmp = new ArrayList<>();
                        tmp.add(elem);
                        logs.put(elem.getContainer_id(), tmp);
                    }

                    // Read the next element
                    line = reader.readLine();
                }

                // For each element inside the Hashtable sort his list of LogFormat
                logs.forEach((node_id , nodeLogs) -> {
                    Collections.sort(nodeLogs);
                });
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                logs = new Hashtable<>();
                return false;
            }
        }
        return false;
    }


}
