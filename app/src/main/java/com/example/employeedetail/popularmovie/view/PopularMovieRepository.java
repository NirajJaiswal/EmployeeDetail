package com.example.employeedetail.popularmovie.view;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.employeedetail.R;
import com.example.employeedetail.popularmovie.model.Movie;
import com.example.employeedetail.popularmovie.model.MovieDbResponse;
import com.example.employeedetail.popularmovie.service.PopularMovieService;
import com.example.employeedetail.popularmovie.service.RetrofitMovieInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieRepository
{
    private Application application;
    private List<Movie> movies=new ArrayList<>();
    private MutableLiveData<List<Movie>>mutableLiveDataMovieList=new MutableLiveData<>();

    public PopularMovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveDataMovieList()
    {
        PopularMovieService popularMovieService= RetrofitMovieInstance.getService();
        Call<MovieDbResponse> call=popularMovieService.getPopularMovie(application.getString(R.string.api_key));

        call.enqueue(new Callback<MovieDbResponse>() {
            @Override
            public void onResponse(Call<MovieDbResponse> call, Response<MovieDbResponse> response) {
                if(response.body()!=null && response.body().getMovies()!=null)
                {
                    movies=  response.body().getMovies();
                    mutableLiveDataMovieList.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<MovieDbResponse> call, Throwable t) {

            }
        });
        return mutableLiveDataMovieList;
    }
}
