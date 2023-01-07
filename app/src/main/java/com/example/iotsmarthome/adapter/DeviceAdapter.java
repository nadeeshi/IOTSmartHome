package com.example.iotsmarthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iotsmarthome.R;
import com.example.iotsmarthome.model.Device;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    Context context;
    private List<Device> deviceList;
    public Switch lightSwitchButton;

    public DeviceAdapter(List<Device> deviceList, Context context) {
        this.deviceList = deviceList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_room_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Device device = deviceList.get(position);

        holder.title.setText(device.getName());

        //setup initial toggle values
        if(lightSwitchButton.isChecked()) {
            lightSwitchButton.setText("On");
        }else{
            lightSwitchButton.setText("Off");
        }
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            cardView = view.findViewById(R.id.card_view);

            lightSwitchButton = view.findViewById(R.id.switchButton);

            //Change toggle values when manually controlling devices
            Switch sw = (Switch) view.findViewById(R.id.switchButton);
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        sw.setText("On");
                        // deviceControlService.controlDevice("turn on light");
                    } else {
                        sw.setText("Off");
                        //  deviceControlService.controlDevice("turn off light");
                    }
                }
            });
        }
    }
}
