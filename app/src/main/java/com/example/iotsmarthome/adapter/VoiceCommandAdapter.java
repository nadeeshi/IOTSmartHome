package com.example.iotsmarthome.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iotsmarthome.NewRoomDetailsActivity;
import com.example.iotsmarthome.R;
import com.example.iotsmarthome.model.Room;
import com.example.iotsmarthome.model.VoiceCommand;

import java.util.List;

public class VoiceCommandAdapter extends RecyclerView.Adapter<VoiceCommandAdapter.MyViewHolder>{

    Context context;
    private List<VoiceCommand> roomList;

    public VoiceCommandAdapter(List<VoiceCommand> roomList, Context context) {
        this.roomList = roomList;
        this.context = context;
    }

    @NonNull
    @Override
    public VoiceCommandAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_new_room, parent, false);

        return new VoiceCommandAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VoiceCommandAdapter.MyViewHolder holder, int position) {
        VoiceCommand room = roomList.get(position);

        holder.title.setText(room.getCommand());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewRoomDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            cardView = view.findViewById(R.id.card_view);

        }
    }
}
