package com.medipol.h5190051_hakan_yucel_final_proje.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.medipol.h5190051_hakan_yucel_final_proje.R;
import com.medipol.h5190051_hakan_yucel_final_proje.activity.HomeActivity;

public class DialogUtil {
    public void launchAlertDialog(Activity activity, String title, String message, String negativeButton, String positiveButton, AlertTypes type){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(type == AlertTypes.Network)
                    activity.finish();
            }
        });
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(type == AlertTypes.Network)
                    activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                else
                    activity.finish();
            }
        });
        builder.show();
    }

    public enum AlertTypes {OnBack, Network}
}
