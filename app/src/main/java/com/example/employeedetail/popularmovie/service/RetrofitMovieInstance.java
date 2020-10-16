package com.example.employeedetail.popularmovie.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMovieInstance
{
    private static Retrofit retrofit=null;
    private static String BASE_URL="https://api.themoviedb.org/3/";

    public static PopularMovieService getService()
    {
        if(retrofit==null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PopularMovieService.class);
    }
}
