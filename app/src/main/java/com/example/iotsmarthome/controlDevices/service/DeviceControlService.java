package com.example.iotsmarthome.controlDevices.service;

public class DeviceControlService {

    ConnectionService connectionService = new ConnectionService();

    public void controlDevice(String command) {
//        if (command.equals("turn on") || command.equals("light turn on")) {
            connectionService.run("tdtool --on 3");
//        } else if (command.equals("turn off") || command.equals("light turn off")) {
//            connectionService.run("tdtool --off 3");
//        }
    }
}
