package com.example.iotsmarthome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iotsmarthome.R;
import com.example.iotsmarthome.model.Room;
import com.example.iotsmarthome.model.VoiceCommand;

import java.util.List;

public class SingleCommandAdapter extends RecyclerView.Adapter<SingleCommandAdapter.MyViewHolder> {
    Context context;
    private List<VoiceCommand> roomList;

    public SingleCommandAdapter(List<VoiceCommand> roomList, Context context) {
        this.roomList = roomList;
        this.context = context;
    }

    @Override
    public SingleCommandAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_room_row, parent, false);

        return new SingleCommandAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SingleCommandAdapter.MyViewHolder holder, int position) {
        VoiceCommand room = roomList.get(position);

        holder.title.setText(room.getCommand());

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
