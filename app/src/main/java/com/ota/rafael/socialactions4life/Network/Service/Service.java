package com.ota.rafael.socialactions4life.Network.Service;


import com.ota.rafael.socialactions4life.Entity.AcoesListEntity;
import com.ota.rafael.socialactions4life.Entity.DetailEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rafael on 17/12/2017.
 */

public interface Service {

    @GET("sociais.json")
    Call<AcoesListEntity> getAcoes();

    @GET("id")
    Call<DetailEntity> getActionDetail(@Query("id") long actionId);

}

