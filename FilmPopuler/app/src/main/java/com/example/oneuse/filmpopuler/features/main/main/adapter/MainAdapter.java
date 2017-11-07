package com.example.oneuse.filmpopuler.features.main.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oneuse.filmpopuler.R;

import com.example.oneuse.filmpopuler.features.main.main.contract.MainListItemClicklistener;
import com.example.oneuse.filmpopuler.features.main.main.contract.MovieitemClickListener;
import com.example.oneuse.filmpopuler.features.main.main.model.MainItem;
import com.example.oneuse.filmpopuler.features.main.main.model.MovieItem;
import com.example.oneuse.filmpopuler.features.main.main.view.BaseViewHolder;
import com.example.oneuse.filmpopuler.features.main.main.view.BigMovieViewHolder;
import com.example.oneuse.filmpopuler.features.main.main.view.HeaderViewHolder;
import com.example.oneuse.filmpopuler.features.main.main.view.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<MainItem> mainItemList;
    private MainListItemClicklistener mainListItemClickListener;
    private MovieitemClickListener movieItemClickListener;

    public MainAdapter(MainListItemClicklistener mainListItemClickListener) {
        this.mainListItemClickListener = mainListItemClickListener;
        this.mainItemList = new ArrayList<>();
        setupMovieItemClickListener();
    }

    private void setupMovieItemClickListener() {
        movieItemClickListener = new MovieitemClickListener() {
            @Override
            public void onMovieItemClicked(int position) {
                MainItem item = mainItemList.get(position);
                if (mainListItemClickListener != null) {
                    mainListItemClickListener.onMovieItemClick((MovieItem) item);
                }
            }
        };
    }

    public void setMainItemList(List<MainItem> mainItemList) {
        this.mainItemList = mainItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mainItemList.get(position).getType();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(viewType, viewGroup, false);
        if (viewType == R.layout.main_movie_item) {
            return new MovieViewHolder(view, movieItemClickListener);
        } else if (viewType == R.layout.main_big_movie_item) {
            return new BigMovieViewHolder(view, movieItemClickListener);
        } else if (viewType == R.layout.main_header_item) {
            return new HeaderViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int pos) {
        baseViewHolder.bindView(mainItemList.get(pos));
    }

    @Override
    public int getItemCount() {
        return mainItemList.size();
    }

    public int getItemSize(int position) {
        if (position >= mainItemList.size() || position < 0) {
            return 0;
        } else {
            return mainItemList.get(position).getItemSize();
        }
    }
}