package com.ota.rafael.socialactions4life.SocialActionsList;


import com.ota.rafael.socialactions4life.Entity.AcaoSocial;

import java.util.List;

/**
 * Created by Rafael on 17/12/2017.
 */

public interface SocialActionsListView {
    void updateList(List<AcaoSocial> movieList);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
