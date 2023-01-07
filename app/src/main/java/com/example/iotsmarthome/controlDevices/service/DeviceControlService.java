package com.example.iotsmarthome.controlDevices.service;

public class DeviceControlService {

    ConnectionService connectionService = new ConnectionService();

    public void controlDevice(String command) {
        if (command.equals("devices") || command.equals("light devices")) {
          String[]  devices_list = connectionService.run("tdtool --list-devices");

        System.out.println(devices_list[0]);
//            type=device	id=2	name=Actuator1	lastsentcommand=ON
        System.out.println(devices_list[1]);
//            type=device	id=2	name=Actuator1	lastsentcommand=ON
        System.out.println(devices_list[2]);
//            type=device	id=2	name=Actuator1	lastsentcommand=ON

         //Extract Device id
            String device_id = devices_list[0].split("\\s+")[1];
          System.out.println(device_id);
//            id=2
//            extract exact id number
            System.out.println(device_id.split("\\=")[1]);
//            2

        } else if (matchTurnOnLightWords(command)) {
            String[]  response = connectionService.run("tdtool --on 2");
            System.out.println(response);
            System.out.println(response[0]);
            System.out.println(response[0].split("\\s+")[1]);
        } else if (matchTurnOffLightWords(command)) {
            String[]  response = connectionService.run("tdtool --off 2");
            System.out.println(response);
            System.out.println(response[0]);
            System.out.println(response[0].split("\\s+")[1]);
        }else if (command.equals("sensors") || command.equals("light sensors")) {

//           type=sensor	protocol=fineoffset	model=temperaturehumidity	id=135	temperature=22.8	humidity=35	time=2022-12-27 18:38:16	age=24
//           type=sensor	protocol=fineoffset	model=temperaturehumidity	id=247	temperature=20.3	humidity=38	time=2022-12-27 18:38:10	age=30
            String[] sensors_list = connectionService.run("tdtool --list-sensors");

            System.out.println(sensors_list[0]);
            System.out.println(sensors_list[1]);
            System.out.println(sensors_list[2]);

            //Extract Sensor id
            String sensor_id = sensors_list[0].split("\\s+")[3];
            System.out.println(sensor_id);
//           Extract temperature
            String temprature = sensors_list[0].split("\\s+")[4];
//            temperature=22.8
            System.out.println(temprature);
            //            extract temperature value
            System.out.println(temprature.split("\\=")[1]);
//            22.8
        }

    }
    private boolean matchTurnOnLightWords(String command) {
        return command.contains("turn on") || command.contains("light turn on") || command.contains("turn on light") || command.contains("turn on the light")
                || command.contains("then on light") || command.contains("the on light");
    }

    private boolean matchTurnOffLightWords(String command) {
        return command.contains("turn off") || command.contains("light turn off") || command.contains("turn off light") || command.contains("turn off the light")
                || command.contains("then off light") || command.contains("the off light");
    }
}
