package com.medipol.h5190051_hakan_yucel_final_proje.util;

import com.google.gson.Gson;
import com.medipol.h5190051_hakan_yucel_final_proje.model.PlayerModel;

public class ObjectUtil {

    public static String playerToJsonString(PlayerModel player)
    {
        Gson gson = new Gson();
        return gson.toJson(player);
    }

    public static PlayerModel jsonStringToPlayer(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, PlayerModel.class);
    }
}
