package com.medipol.h5190051_hakan_yucel_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.medipol.h5190051_hakan_yucel_final_proje.model.PlayerModel;
import com.medipol.h5190051_hakan_yucel_final_proje.R;
import com.medipol.h5190051_hakan_yucel_final_proje.util.Constants;
import com.medipol.h5190051_hakan_yucel_final_proje.util.GlideUtil;
import com.medipol.h5190051_hakan_yucel_final_proje.util.ObjectUtil;

public class PlayerDetailActivity extends AppCompatActivity {

    // Define variables
    ImageView imgPlayerDetail;
    TextView txtPlayerTitle, txtPlayerLife, txtPlayerBorn, txtPlayerSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        init();
    }

    private void init(){
        // Connect to activity
        imgPlayerDetail = findViewById(R.id.imgPlayerDetail);
        txtPlayerTitle = findViewById(R.id.txtPlayerTitle);
        txtPlayerLife = findViewById(R.id.txtPlayerLife);
        txtPlayerBorn = findViewById(R.id.txtPlayerBorn);
        txtPlayerSize = findViewById(R.id.txtPlayerSize);

        // Get player model by json string
        PlayerModel player = getPlayerModel(getIntent().getStringExtra(Constants.CLICKED_PLAYER));

        txtPlayerTitle.setText(player.getName());
        txtPlayerLife.setText(player.getLife());
        txtPlayerBorn.setText(player.getBirthday());
        txtPlayerSize.setText(player.getSize());
        GlideUtil.getImage(getApplicationContext(), player.getBannerUrl(), imgPlayerDetail);
    }

    private PlayerModel getPlayerModel(String playerJsonString){
        PlayerModel player = ObjectUtil.jsonStringToPlayer(playerJsonString);
        return player;
    }
}