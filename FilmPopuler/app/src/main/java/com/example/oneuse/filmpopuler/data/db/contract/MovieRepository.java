package com.example.oneuse.filmpopuler.data.db.contract;

import com.example.oneuse.filmpopuler.data.model.MovieData;

import java.util.List;

/**
 * Created by ONEUSE on 30/10/2017.
 */

public interface MovieRepository {
    List<MovieData> getFavoriteMovie();

    void addFavoriteMovie(MovieData movieData);

    boolean isMovieFavored(String movieId);

    void updateFavoriteMovie(MovieData movieData);

    void removeFavoriteMovie(String movieId);
}