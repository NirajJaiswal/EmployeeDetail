package com.example.employeedetail.popularmovie.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.employeedetail.popularmovie.model.Movie;
import com.example.employeedetail.popularmovie.view.PopularMovieRepository;

import java.util.List;

public class PopularMovieViewModel extends AndroidViewModel
{
    private PopularMovieRepository repository;
    public LiveData<List<Movie>>listLiveDataMovie;


    public PopularMovieViewModel(@NonNull Application application) {
        super(application);
        repository=new PopularMovieRepository(application);
    }

    public LiveData<List<Movie>> getListLiveDataMovie()
    {
        listLiveDataMovie=repository.getMutableLiveDataMovieList();
        return listLiveDataMovie;
    }
}
