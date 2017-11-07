package com.example.oneuse.filmpopuler.features.main.contracts;


public final class AddOrDeleteFavoriteMovieContract {
    public static final String ACTION_FAVORITE_MOVIE_DATA_CHANGED = "com.berbageek.filmpopuler.features.contracts.ACTION_FAVORITE_MOVIE_DATA_CHANGED";

    public static final String ACTION_ADD_FAVORITE = "com.berbageek.filmpopuler.features.contracts.ACTION_ADD_FAVORITE";
    public static final String ACTION_DELETE_FAVORITE = "com.berbageek.filmpopuler.features.contracts.ACTION_DELETE_FAVORITE";

    public static final String EXTRA_MOVIE_DATA = "EXTRA_MOVIE_DATA";
    public static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";

    private AddOrDeleteFavoriteMovieContract() {
    }
}