package com.ota.rafael.socialactions4life.SocialActionsList;

import com.ota.rafael.socialactions4life.Entity.AcaoSocial;
import com.ota.rafael.socialactions4life.Entity.AcoesListEntity;
import com.ota.rafael.socialactions4life.Network.Api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SocialActionsListPresenter {
    private SocialActionsListView actionsView;
    private AcoesListEntity actionsListEntity;
    private List<AcaoSocial> actionsList;

    SocialActionsListPresenter(SocialActionsListView actionsView){
        this.actionsView = actionsView;
    }

    void updateList(){
        final Api acoesApi = Api.getInstance();
        actionsView.showLoading();
        acoesApi.getAcoes().enqueue(new Callback<AcoesListEntity>() {
            @Override
            public void onResponse(Call<AcoesListEntity> call, Response<AcoesListEntity> response) {
                actionsView.hideLoading();
                actionsListEntity = response.body();
                if(actionsListEntity != null){
                    actionsList = actionsListEntity.getAcoesSociais();
                    actionsView.updateList(actionsList);
                    //actionsView.AtivarRecycler();
                } else {
                    actionsView.showMessage("Falha no login");
                }
            }

            @Override
            public void onFailure(Call<AcoesListEntity> call, Throwable t) {
                actionsView.hideLoading();
                actionsView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

    long getActionId(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getId();
    }

    String getActionName(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getName();
    }
    String getActionDescription(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getDescription();
    }
    String getActionSite(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getSite();
    }
    String getActionImage(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getImage();
    }


}
