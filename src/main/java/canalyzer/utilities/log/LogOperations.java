package canalyzer.utilities.log;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public class LogOperations {

    /**
     * Compare two apps timestamps
     * @param app1 first app timestamp
     * @param app2 second app timestamp
     * @return return 0 if the two argument are equals, returns less than 0 if the first is
     * numerically less than second or if is empty, otherwise return grater than 0
     */
    public static int compareAppTimeStamp(@NotNull String app1, @NotNull String app2){
        if(app1.isBlank() && app2.isBlank()) {
            return 0;
        }
        else if(app1.isBlank()){
            return -1;
        }
        else if(app2.isBlank()){
            return 1;
        }
        else{
            Double appTs = Double.parseDouble(app1);
            Double comparedTs = Double.parseDouble(app2);
            return appTs.compareTo(comparedTs);
        }
    }

    /**
     * Compare two dockers timestamps
     * @param app1 firs docker timestamp
     * @param app2 second docker timestamp
     * @return return 0 if the two argument are equals, returns less than 0 if the first is
     *      * numerically less than second or if is empty, otherwise return grater than 0
     */
    public static int compareDockerTimeStamp(@NotNull String app1, @NotNull String app2){
        if(app1.isBlank() && app2.isBlank()) {
            return 0;
        }
        else if(app1.isBlank()){
            return -1;
        }
        else if(app2.isBlank()){
            return 1;
        }
        else{
            Long dockerTs = Instant.parse(app1).toEpochMilli();
            Long comparedTs = Instant.parse(app2).toEpochMilli();
            return dockerTs.compareTo(comparedTs);
        }
    }
}
