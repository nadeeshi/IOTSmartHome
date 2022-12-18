package com.example.iotsmarthome.controlDevices.service;

public class DeviceControlService {

    ConnectionService connectionService;

    public void controlDevice(String command) {
        if (command.equals("turn on") || command.equals("light turn on")) {
            connectionService.run("python turnondevices.py");
        } else if (command.equals("turn off") || command.equals("light turn off")) {
            connectionService.run("python turnoffdevice.py");
        }
    }
}
