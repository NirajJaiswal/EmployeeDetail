package com.example.employeedetail.popularmovie.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.employeedetail.R;
import com.example.employeedetail.databinding.ActivityPopularMovieBinding;
import com.example.employeedetail.popularmovie.adapter.PopularMovieAdapter;
import com.example.employeedetail.popularmovie.listener.MovieListener;
import com.example.employeedetail.popularmovie.model.Movie;
import com.example.employeedetail.popularmovie.viewmodel.PopularMovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class PopularMovieActivity extends AppCompatActivity implements MovieListener {
    private ArrayList<Movie>movieArrayList;
    private RecyclerView recyclerView;
    private PopularMovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private PopularMovieViewModel viewModel;
    private ActivityPopularMovieBinding activityPopularMovieBinding;
    private Boolean isListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_movie);
        isListView=false;

        activityPopularMovieBinding= DataBindingUtil.setContentView(this,R.layout.activity_popular_movie);
        viewModel= new ViewModelProvider(this).get(PopularMovieViewModel.class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Popular Movie");
        getPopularMovie();
        swipeRefreshLayout=activityPopularMovieBinding.swipeLayout;
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

        viewModel.getListLiveDataMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieArrayList= (ArrayList<Movie>) movies;
                getRecyclerView();

            }
        });

            }




    private void getRecyclerView() {
        recyclerView=activityPopularMovieBinding.rvPopularMovie;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.movie_menu_bar,menu);
        MenuItem menuItem=menu.findItem(R.id.movie_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               adapter.getFilter().filter(newText);
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.movie_list){
            recyclerView.setLayoutManager(! isListView ? new LinearLayoutManager(this): new GridLayoutManager(this,2));
           adapter.notifyDataSetChanged();
           return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        if(isListView){
            menu.findItem(R.id.movie_list).setTitle("List View");
            isListView=false;
        }
        else{
            menu.findItem(R.id.movie_list).setTitle("Grid View");
            isListView=true;
        }

        return super.onPrepareOptionsMenu(menu);
    }
}