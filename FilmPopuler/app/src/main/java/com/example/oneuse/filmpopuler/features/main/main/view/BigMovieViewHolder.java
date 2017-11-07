package com.example.oneuse.filmpopuler.features.main.main.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oneuse.filmpopuler.R;
import com.example.oneuse.filmpopuler.data.api.TmdbConstant;
import com.example.oneuse.filmpopuler.features.main.main.contract.MovieitemClickListener;
import com.example.oneuse.filmpopuler.features.main.main.model.BigMovieItem;
import com.example.oneuse.filmpopuler.features.main.main.model.MainItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class BigMovieViewHolder extends BaseViewHolder {

    private static final String SMALL_POSTER_SIZE = "w342/";

    private ImageView posterImageView;
    private TextView movieTitleField;
    private TextView movieOverviewField;
    private ViewGroup movieInfoWrapper;
    private MovieitemClickListener listener;
    private String imageSize = SMALL_POSTER_SIZE;

    private Target target;

    public BigMovieViewHolder(View itemView, MovieitemClickListener itemListener) {
        super(itemView);
        this.listener = itemListener;

        setupViews(itemView);
    }

    private void setupViews(final View itemView) {
        posterImageView = itemView.findViewById(R.id.big_movie_item_poster_image);
        movieTitleField = itemView.findViewById(R.id.big_movie_item_title);
        movieOverviewField = itemView.findViewById(R.id.big_movie_item_overview);
        movieInfoWrapper = itemView.findViewById(R.id.big_movie_item_info_wrapper);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int pos = getAdapterPosition();
                if (listener != null && pos != RecyclerView.NO_POSITION) {
                    listener.onMovieItemClicked(pos);
                }
            }
        });

        target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                if (posterImageView != null) {
                    posterImageView.setImageBitmap(bitmap);
                }
                final int twentyFourDip = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        24,
                        itemView.getContext().getResources().getDisplayMetrics()
                );
                Palette.from(bitmap)
                        .maximumColorCount(32)
                        /* by default palette ignore certain hues (e.g. pure black/white) but we don't want this. */
                        .clearFilters()
                        /* - 1 to work around https://code.google.com/p/android/issues/detail?id=191013 */
//                        .setRegion(0, 0, bitmap.getWidth() - 1, twentyFourDip)
                        .generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                Palette.Swatch swatch = palette.getVibrantSwatch();
                                if (swatch != null) {
                                    setupViewColor(swatch);
                                } else {
                                    swatch = palette.getDominantSwatch();
                                    if (swatch != null) {
                                        setupViewColor(swatch);
                                    }
                                }
                            }

                            private void setupViewColor(Palette.Swatch swatch) {
                                if (movieInfoWrapper != null) {
                                    movieInfoWrapper.setBackgroundColor(swatch.getRgb());
                                }
                                if (movieTitleField != null) {
                                    movieTitleField.setTextColor(swatch.getTitleTextColor());
                                }
                                if (movieOverviewField != null) {
                                    movieOverviewField.setTextColor(swatch.getBodyTextColor());
                                }
                            }
                        });
            }

            @Override
            public void onBitmapFailed(Drawable drawable) {
                if (posterImageView != null) {
                    posterImageView.setImageDrawable(drawable);
                }
            }

            @Override
            public void onPrepareLoad(Drawable drawable) {
                if (posterImageView != null) {
                    posterImageView.setImageDrawable(drawable);
                }
            }
        };
    }

    @Override
    public void bindView(MainItem item) {
        BigMovieItem movieItem = (BigMovieItem) item;
        movieTitleField.setText(movieItem.getMovieTitle());
        movieOverviewField.setText(movieItem.getOverview());
        Picasso.with(itemView.getContext())
                .load(TmdbConstant.IMAGE_BASE_URL + imageSize + movieItem.getPosterPath())
                .placeholder(R.drawable.ic_image_black_24dp)
                .error(R.drawable.ic_broken_image_black_24dp)
                .into(target);
    }
}