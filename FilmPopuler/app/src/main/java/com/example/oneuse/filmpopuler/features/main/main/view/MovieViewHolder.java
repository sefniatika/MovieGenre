package com.example.oneuse.filmpopuler.features.main.main.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.oneuse.filmpopuler.R;
import com.example.oneuse.filmpopuler.data.api.TmdbConstant;
import com.example.oneuse.filmpopuler.features.main.main.contract.MovieitemClickListener;
import com.example.oneuse.filmpopuler.features.main.main.model.MainItem;
import com.example.oneuse.filmpopuler.features.main.main.model.StandardMovieItem;
import com.squareup.picasso.Picasso;

public class MovieViewHolder extends BaseViewHolder {

    private static final String SMALL_POSTER_SIZE = "w342/";
    private static final String MEDIUM_POSTER_SIZE = "w500/";

    private ImageView posterImageView;
    private MovieitemClickListener listener;
    private String imageSize;

    public MovieViewHolder(View itemView, MovieitemClickListener itemListener) {
        super(itemView);
        this.listener = itemListener;

        setupViews(itemView);
    }

    private void setupViews(View itemView) {
        posterImageView = itemView.findViewById(R.id.movie_item_poster_image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int pos = getAdapterPosition();
                if (listener != null && pos != RecyclerView.NO_POSITION) {
                    listener.onMovieItemClicked(pos);
                }
            }
        });
    }

    private void setImageSize(int position) {
        imageSize = positionDivisibleByFive(position) ? MEDIUM_POSTER_SIZE : SMALL_POSTER_SIZE;
    }

    private boolean positionDivisibleByFive(int position) {
        return position != RecyclerView.NO_POSITION && (position % 5 == 0);
    }

    @Override
    public void bindView(MainItem item) {
        StandardMovieItem standardMovieItem = (StandardMovieItem) item;
        setImageSize(getAdapterPosition());
        Picasso.with(itemView.getContext())
                .load(TmdbConstant.IMAGE_BASE_URL + imageSize + standardMovieItem.getPosterPath())
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_broken_image_black_24dp)
                .into(posterImageView);
    }
}