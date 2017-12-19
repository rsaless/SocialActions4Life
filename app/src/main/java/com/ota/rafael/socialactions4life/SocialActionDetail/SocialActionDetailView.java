package com.ota.rafael.socialactions4life.SocialActionDetail;

import com.ota.rafael.socialactions4life.Entity.DetailEntity;

/**
 * Created by Rafael on 17/12/2017.
 */

public interface SocialActionDetailView {
    void showDetails(DetailEntity detailEntity);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}