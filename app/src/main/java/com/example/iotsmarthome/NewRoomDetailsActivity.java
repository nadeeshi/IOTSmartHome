package com.example.iotsmarthome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.iotsmarthome.adapter.SingleRoomAdapter;
import com.example.iotsmarthome.model.Room;

import java.util.ArrayList;
import java.util.List;

public class NewRoomDetailsActivity extends AppCompatActivity {
    private List<Room> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SingleRoomAdapter mAdapter;

    RelativeLayout setting_rl;

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_room_details);

        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new SingleRoomAdapter(roomList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareRoomData();

        setting_rl = findViewById(R.id.setting_rl);
        setting_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), VoiceCommandListActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void prepareRoomData() {
        Room room = new Room("1", "Light");
        roomList.add(room);
        room = new Room("2", "Fan");
        roomList.add(room);
        room = new Room("1", "Air Conditioner");
        roomList.add(room);
        room = new Room("1", "TV");
        roomList.add(room);

        mAdapter.notifyDataSetChanged();
    }

    public void onBackClicked(View view) {
        startActivity(new Intent(getApplicationContext(), RoomSelectionActivity.class));
        finish();
    }
}