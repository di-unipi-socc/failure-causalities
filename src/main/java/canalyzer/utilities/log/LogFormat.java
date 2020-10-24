package canalyzer.utilities.log;

import java.io.Serializable;

// Class which identifies the format of Pong log format
public class LogFormat implements Serializable {
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


}
