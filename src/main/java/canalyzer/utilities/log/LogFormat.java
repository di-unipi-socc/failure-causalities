package canalyzer.utilities.log;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

// Class which identifies the format of Pong log format
public class LogFormat implements Serializable, Comparable {
    private String container_id;
    private String container_name;
    private String docker_timestamp;
    private String app_timestamp;
    private String message;
    private String label;
    private String info;

    public LogFormat(String container_id, String container_name, String docker_timestamp, String app_timestamp, String message, String label, String info) {
        this.container_id = container_id;
        this.container_name = container_name;
        this.docker_timestamp = docker_timestamp;
        this.app_timestamp = app_timestamp;
        this.message = message;
        this.label = label;
        this.info = info;
    }

    public LogFormat() {
    }

    public String getContainer_id() {
        return container_id;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        LogFormat compareLog = (LogFormat)o;
        // app_timestamp present in both log
        if (!this.app_timestamp.isBlank() && !compareLog.app_timestamp.isBlank()){
            return LogOperations.compareAppTimeStamp(this.app_timestamp, compareLog.app_timestamp);
        }
        // app_timestamp missing in one log
       return LogOperations.compareDockerTimeStamp(this.docker_timestamp, compareLog.docker_timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogFormat)) return false;
        LogFormat logFormat = (LogFormat) o;
        return container_id.equals(logFormat.container_id) &&
                container_name.equals(logFormat.container_name) &&
                docker_timestamp.equals(logFormat.docker_timestamp) &&
                app_timestamp.equals(logFormat.app_timestamp) &&
                message.equals(logFormat.message) &&
                label.equals(logFormat.label) &&
                info.equals(logFormat.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(container_id, container_name, docker_timestamp, app_timestamp, message, label, info);
    }
}
