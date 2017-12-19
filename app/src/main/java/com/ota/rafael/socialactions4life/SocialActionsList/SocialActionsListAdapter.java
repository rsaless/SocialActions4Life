package com.ota.rafael.socialactions4life.SocialActionsList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ota.rafael.socialactions4life.Entity.AcaoSocial;
import com.ota.rafael.socialactions4life.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rafael on 18/12/2017.
 */

public class SocialActionsListAdapter extends RecyclerView.Adapter<SocialActionsListAdapter.ViewHolder>{

    private List<AcaoSocial> actionsList;
    private Context context;
    OnRecyclerViewSelected onRecyclerViewSelected;

    public SocialActionsListAdapter (List<AcaoSocial> actionsList, Context context){
        this.actionsList = actionsList;
        this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context)
                .load(actionsList.get(position).getImage())
                .centerCrop()
                .fit()
                .into(holder.ivBackground);
        holder.tvHeading.setText(actionsList.get(position).getName());
        holder.tvDescription.setText(actionsList.get(position).getDescription());
    }

    @Override public int getItemCount() {
        return actionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_background)
        ImageView ivBackground;
        @BindView(R.id.iv_heading)
        TextView tvHeading;
        @BindView(R.id.iv_description) TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
