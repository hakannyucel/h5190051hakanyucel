package com.medipol.h5190051_hakan_yucel_final_proje.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.medipol.h5190051_hakan_yucel_final_proje.R;

public class GlideUtil {

    public static void getImage(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.logo)
                .centerCrop()
                .into(img);
    }
}
