package com.medipol.h5190051_hakan_yucel_final_proje.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.medipol.h5190051_hakan_yucel_final_proje.model.PlayerModel;
import com.medipol.h5190051_hakan_yucel_final_proje.R;
import com.medipol.h5190051_hakan_yucel_final_proje.util.GlideUtil;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder> {

    List<PlayerModel> players;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public PlayerAdapter(List<PlayerModel> players, Context context, OnItemClickListener listener) {
        this.players = players;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_player,parent,false);
        return new PlayerViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder viewHolder, int position) {
        viewHolder.txtPlayerName.setText(players.get(position).getName());
        viewHolder.txtSize.setText(players.get(position).getSize());
        viewHolder.txtDate.setText(players.get(position).getBirthday());
        GlideUtil.getImage(context,players.get(position).getImageUrl(),viewHolder.imgPlayer);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
