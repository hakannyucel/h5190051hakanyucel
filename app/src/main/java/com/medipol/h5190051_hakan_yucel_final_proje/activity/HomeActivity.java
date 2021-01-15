package com.medipol.h5190051_hakan_yucel_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.medipol.h5190051_hakan_yucel_final_proje.model.PlayerModel;
import com.medipol.h5190051_hakan_yucel_final_proje.R;
import com.medipol.h5190051_hakan_yucel_final_proje.adaptor.PlayerAdapter;
import com.medipol.h5190051_hakan_yucel_final_proje.network.Service;
import com.medipol.h5190051_hakan_yucel_final_proje.util.Constants;
import com.medipol.h5190051_hakan_yucel_final_proje.util.DialogUtil;
import com.medipol.h5190051_hakan_yucel_final_proje.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    DialogUtil dialogUtil = new DialogUtil();

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage(getString(R.string.progress_dialog_message));
        progressDialog.show();

        init();
    }

    private  void  init()
    {
        getPlayers();
    }

    private void getPlayers()
    {
        new Service().getServiceApi().getAllPlayers().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PlayerModel>>() {
                    List<PlayerModel> players = new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(List<PlayerModel> playerList) {
                        players = playerList;
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete()
                    {
                        if(players.size() > 0)
                            initRecycleView(players);

                        progressDialog.dismiss();
                    }
                });
    }

    private void initRecycleView(List<PlayerModel> playerList)
    {
        recyclerView = findViewById(R.id.rcv_players);

        PlayerAdapter playerAdapter = new PlayerAdapter(playerList, getApplicationContext(), new PlayerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                PlayerModel player = playerList.get(position);
                openPlayerDetailActivity(player);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(playerAdapter);
    }

    private void openPlayerDetailActivity(PlayerModel player){
        String playerJsonString = ObjectUtil.playerToJsonString(player);
        Intent playerDetailActivity = new Intent(getApplicationContext(), PlayerDetailActivity.class);
        playerDetailActivity.putExtra(Constants.CLICKED_PLAYER, playerJsonString);
        startActivity(playerDetailActivity);
    }

    public void onBackPressed() {
        String title = getString(R.string.back_alert_title);
        String message = getString(R.string.back_alert_message);
        String negativeButton = getString(R.string.back_alert_negative_button);
        String positiveButton = getString(R.string.back_alert_positive_button);
        dialogUtil.launchAlertDialog(HomeActivity.this, title, message, negativeButton, positiveButton, DialogUtil.AlertTypes.OnBack);
    }
}