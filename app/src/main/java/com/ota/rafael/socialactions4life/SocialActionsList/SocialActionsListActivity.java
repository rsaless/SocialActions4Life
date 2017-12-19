package com.ota.rafael.socialactions4life.SocialActionsList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ota.rafael.socialactions4life.Entity.AcaoSocial;
import com.ota.rafael.socialactions4life.Entity.AcoesListEntity;
import com.ota.rafael.socialactions4life.R;
import com.ota.rafael.socialactions4life.SocialActionDetail.SocialActionDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialActionsListActivity extends AppCompatActivity implements SocialActionsListView {

    AcoesListEntity acoesListEntity;

    @BindView(R.id.rv_actions)
    RecyclerView rvActions;
    @BindView(R.id.linear_layout_loading)
    LinearLayout loadingLayout;

    SocialActionsListPresenter actionsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_action_list);

        ButterKnife.bind(this);
        actionsPresenter = new SocialActionsListPresenter(this);
        actionsPresenter.updateList();
    }


    @Override public void updateList(List<AcaoSocial> actionsList) {

        SocialActionsListAdapter actionsAdapter = new SocialActionsListAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(MoviesActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
                Intent openDetailActivity = new Intent(SocialActionsListActivity.this, SocialActionDetailActivity.class);
                openDetailActivity.putExtra("id",actionsPresenter.getActionId(position));
                openDetailActivity.putExtra("name",actionsPresenter.getActionName(position));
                openDetailActivity.putExtra("image",actionsPresenter.getActionImage(position));
                openDetailActivity.putExtra("description",actionsPresenter.getActionDescription(position));
                openDetailActivity.putExtra("site",actionsPresenter.getActionSite(position));
                startActivity(openDetailActivity);
            }
        });

        rvActions.setAdapter(actionsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvActions.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvActions.addItemDecoration(dividerItemDecoration);
    }
    @Override public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }
    @Override public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }
}
