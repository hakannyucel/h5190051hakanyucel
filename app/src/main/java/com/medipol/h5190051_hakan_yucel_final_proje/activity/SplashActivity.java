package com.medipol.h5190051_hakan_yucel_final_proje.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.medipol.h5190051_hakan_yucel_final_proje.util.DialogUtil;
import com.medipol.h5190051_hakan_yucel_final_proje.util.NetworkUtil;
import com.medipol.h5190051_hakan_yucel_final_proje.R;

public class SplashActivity extends AppCompatActivity {

    DialogUtil dialogUtil = new DialogUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init(){
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if(NetworkUtil.isNetworkConnected(getApplicationContext()) == false){

                    String title = getString(R.string.network_title);
                    String message = getString(R.string.network_message);
                    String negativeButton = getString(R.string.network_negative_button);
                    String positiveButton = getString(R.string.network_positive_button);
                    dialogUtil.launchAlertDialog(SplashActivity.this, title, message, negativeButton, positiveButton, DialogUtil.AlertTypes.Network);
                }
                else{
                    openHomeActivity();
                }
            }
        }.start();
    }

    private void openHomeActivity(){
        Intent mainActivity = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(mainActivity);
        finish();
    }
}