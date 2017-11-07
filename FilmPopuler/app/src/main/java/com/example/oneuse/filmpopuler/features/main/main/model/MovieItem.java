package com.example.oneuse.filmpopuler.features.main.main.model;

import com.example.oneuse.filmpopuler.data.model.MovieData;

/**
 * Created by ONEUSE on 24/10/2017.
 */

public interface MovieItem extends MainItem {
    String getMovieId();

    String getMovieTitle();

    String getPosterPath();

    MovieData getMovieData();
}
