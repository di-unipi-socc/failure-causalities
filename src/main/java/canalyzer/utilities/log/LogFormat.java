package canalyzer.utilities.log;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

// Class which identifies the format of Pong log format
public class LogFormat implements Serializable, Comparable<Object> {
    private String nodeId;
    private String nodeName;
    private String nodeContainerId;
    private String dockerTimestamp;
    private String timestamp;
    private String message;
    private String label;
    private String info;


    public LogFormat(String nodeId, String nodeName, String nodeContainerId, String dockerTimestamp,
                     String timestamp, String message, String label, String info) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.nodeContainerId = nodeContainerId;
        this.dockerTimestamp = dockerTimestamp;
        this.timestamp = timestamp;
        this.message = message;
        this.label = label;
        this.info = info;
    }

    public LogFormat() {
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getNodeContainerId() {
        return nodeContainerId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        LogFormat compareLog = (LogFormat)o;
        // app_timestamp present in both log
        if (!this.timestamp.isBlank() && !compareLog.timestamp.isBlank()){
            return LogOp.compareTs(this.timestamp, compareLog.timestamp);
        }
        // app_timestamp missing in one log
       return LogOp.compareDTs(this.dockerTimestamp, compareLog.dockerTimestamp);
    }

    @Override
    public String toString() {
        return "{" +
                "nodeId='" + nodeId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", nodeContainerId='" + nodeContainerId + '\'' +
                ", dockerTimestamp='" + dockerTimestamp + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", message='" + message + '\'' +
                ", label='" + label + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogFormat)) return false;
        LogFormat logFormat = (LogFormat) o;
        return Objects.equals(nodeId, logFormat.nodeId) &&
                Objects.equals(nodeName, logFormat.nodeName) &&
                Objects.equals(nodeContainerId, logFormat.nodeContainerId) &&
                Objects.equals(dockerTimestamp, logFormat.dockerTimestamp) &&
                Objects.equals(timestamp, logFormat.timestamp) &&
                Objects.equals(message, logFormat.message) &&
                Objects.equals(label, logFormat.label) &&
                Objects.equals(info, logFormat.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId, nodeName, nodeContainerId, dockerTimestamp, timestamp, message, label, info);
    }
}
