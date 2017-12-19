package com.ota.rafael.socialactions4life.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rafael on 17/12/2017.
 */

public class AcoesListEntity {

    @SerializedName("acoes_sociais") @Expose private List<AcaoSocial> acoesSociais = null;

    public List<AcaoSocial> getAcoesSociais() {
        return acoesSociais;
    }
}
