package com.example.employeedetail.popularmovie.service;

import com.example.employeedetail.popularmovie.model.MovieDbResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PopularMovieService
{
    @GET("movie/popular")
    Call<MovieDbResponse> getPopularMovie(@Query("api_key")String apiKey);
}
