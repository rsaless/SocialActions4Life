package com.ota.rafael.socialactions4life.SocialActionDetail;

import com.ota.rafael.socialactions4life.Entity.DetailEntity;
import com.ota.rafael.socialactions4life.Network.Api.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SocialActionDetailPresenter {

    private SocialActionDetailView view;

    public SocialActionDetailPresenter(SocialActionDetailView view) {
        this.view = view;
    }

    public void getActionDetail(long idMovieSelected) {
        final Api acoesApi =  Api.getInstance();
        view.showLoading();
        acoesApi.getActionDetail(idMovieSelected).enqueue(new Callback<DetailEntity>() {
            @Override
            public void onResponse(Call<DetailEntity> call, Response<DetailEntity> response) {
                view.hideLoading();
                DetailEntity detailEntity = response.body();
                if(detailEntity != null)
                    view.showDetails(detailEntity);
                else
                    view.showMessage("Falha no login");
            }

            @Override
            public void onFailure(Call<DetailEntity> call, Throwable t) {
                view.hideLoading();
                view.showMessage("Falha no acesso ao servidor");
            }
        });
    }
}
