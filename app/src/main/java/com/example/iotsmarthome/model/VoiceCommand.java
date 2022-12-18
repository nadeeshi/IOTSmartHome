package com.example.iotsmarthome.model;

public class VoiceCommand {
    String id;
    String command;

    public VoiceCommand(String id, String command) {
        this.id = id;
        this.command = command;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
