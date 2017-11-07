package com.example.oneuse.filmpopuler.features.main.main.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.oneuse.filmpopuler.features.main.main.model.MainItem;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(MainItem item);
}