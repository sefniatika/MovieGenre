package com.example.oneuse.filmpopuler.data.api;

import com.example.oneuse.filmpopuler.data.model.MovieDataResponse;
import com.example.oneuse.filmpopuler.data.model.MovieDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiService {
    @GET("movie/popular")
    Call<MovieDataResponse> getMostPopularMovies(@Query("page") int page);

    @GET("movie/{movie_id}")
    Call<MovieDetail> getMovieDetail(@Path("movie_id") String movieId);

    @GET("discover/movie")
    Call<MovieDataResponse> getFilter(@Query("with_genres") int genre);
}
