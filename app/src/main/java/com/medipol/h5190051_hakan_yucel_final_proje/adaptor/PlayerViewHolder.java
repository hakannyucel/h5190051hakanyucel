package com.medipol.h5190051_hakan_yucel_final_proje.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.medipol.h5190051_hakan_yucel_final_proje.R;

import org.w3c.dom.Text;

public class PlayerViewHolder extends RecyclerView.ViewHolder {

    ImageView imgPlayer;
    TextView txtPlayerName;
    TextView txtSize;
    TextView txtDate;
    public PlayerViewHolder(@NonNull View cardView, PlayerAdapter.OnItemClickListener listener) {
        super(cardView);

        imgPlayer = cardView.findViewById(R.id.imgPlayer);
        txtPlayerName = cardView.findViewById(R.id.txtPlayerName);
        txtSize = cardView.findViewById(R.id.txtSize);
        txtDate = cardView.findViewById(R.id.txtDate);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
            }
        });
    }
}
