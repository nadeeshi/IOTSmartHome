package com.example.iotsmarthome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.iotsmarthome.adapter.CommandAdapter;
import com.example.iotsmarthome.model.VoiceCommand;
import java.util.ArrayList;
import java.util.List;

public class VoiceCommandListActivity extends AppCompatActivity {

    private List<VoiceCommand> voiceCommandList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CommandAdapter mAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_command_list);

        recyclerView = findViewById(R.id.command_list_view);

        mAdapter = new CommandAdapter(voiceCommandList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareVoiceCommandData();
    }

    private void prepareVoiceCommandData() {
        VoiceCommand voiceCommand = new VoiceCommand("1", "Turn on the light");
        voiceCommandList.add(voiceCommand);
        voiceCommand = new VoiceCommand("2", "Turn off the light");
        voiceCommandList.add(voiceCommand);
        voiceCommand = new VoiceCommand("3", "Turn on the TV");
        voiceCommandList.add(voiceCommand);
        voiceCommand = new VoiceCommand("4", "Turn off the TV");
        voiceCommandList.add(voiceCommand);

        mAdapter.notifyDataSetChanged();
    }

    public void onBackClicked(View view) {
        startActivity(new Intent(getApplicationContext(), RoomSelectionActivity.class));
        finish();
    }
}