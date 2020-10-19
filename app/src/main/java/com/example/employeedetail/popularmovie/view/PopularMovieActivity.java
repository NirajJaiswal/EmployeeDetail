package com.example.employeedetail.popularmovie.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.employeedetail.R;
import com.example.employeedetail.popularmovie.adapter.PopularMovieAdapter;
import com.example.employeedetail.popularmovie.listener.MovieListener;
import com.example.employeedetail.popularmovie.model.Movie;
import com.example.employeedetail.popularmovie.model.MovieDbResponse;
import com.example.employeedetail.popularmovie.service.PopularMovieService;
import com.example.employeedetail.popularmovie.service.RetrofitMovieInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieActivity extends AppCompatActivity implements MovieListener {
    private ArrayList<Movie>movieArrayList;
    private RecyclerView recyclerView;
    private PopularMovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movie);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Popular Movie");
        getPopularMovie();
        swipeRefreshLayout=findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setColorSchemeColors(getColor(R.color.colorPrimaryDark));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovie();

                swipeRefreshLayout.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 5000);

            }
        });
    }

    private void getPopularMovie() {
        PopularMovieService popularMovieService= RetrofitMovieInstance.getService();
        Call<MovieDbResponse>call=popularMovieService.getPopularMovie(getString(R.string.api_key));
        call.enqueue(new Callback<MovieDbResponse>() {
            @Override
            public void onResponse(Call<MovieDbResponse> call, Response<MovieDbResponse> response) {
                if(response.body()!=null && response.body().getMovies()!=null)
                {
                   movieArrayList= (ArrayList<Movie>) response.body().getMovies();
                   getRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<MovieDbResponse> call, Throwable t) {

            }
        });
    }

    private void getRecyclerView() {
        recyclerView=findViewById(R.id.rv_popular_movie);
        adapter=new PopularMovieAdapter(movieArrayList,this);

        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
        {
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onMovieClick(Movie movie)
    {
        if(movie !=null)
        {
            Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(PopularMovieActivity.this,MovieDetailActivity.class);
            intent.putExtra("movie_tag",movie);
            startActivity(intent);
        }

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}