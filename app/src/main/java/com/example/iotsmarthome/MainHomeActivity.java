package com.example.iotsmarthome;

import androidx.appcompat.app.AppCompatActivity;
import com.example.iotsmarthome.controlDevices.service.DeviceControlService;

import android.content.Intent;
import android.os.Bundle;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;

public class MainHomeActivity extends AppCompatActivity {

    BootstrapButton open_room_view_button;
    DeviceControlService deviceControlService = new DeviceControlService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_main_home);

        open_room_view_button = findViewById(R.id.select_room_view_button);

        open_room_view_button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RoomSelectionActivity.class);
            startActivity(intent);
            //Temporary for testing need to move to its place
//            deviceControlService.controlDevice("sensors");
        });
    }
}