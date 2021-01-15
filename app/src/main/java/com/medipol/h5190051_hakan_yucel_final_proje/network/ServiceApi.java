package com.medipol.h5190051_hakan_yucel_final_proje.network;

import com.medipol.h5190051_hakan_yucel_final_proje.model.PlayerModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("TariheGecenOnBasketBolcu.json")
    Observable<List<PlayerModel>> getAllPlayers();
}
