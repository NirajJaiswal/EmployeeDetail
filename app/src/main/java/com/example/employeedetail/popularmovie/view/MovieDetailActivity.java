package com.example.employeedetail.popularmovie.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.example.employeedetail.R;
import com.example.employeedetail.databinding.ActivityMovieDetailBinding;
import com.example.employeedetail.popularmovie.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;
   private ActivityMovieDetailBinding activityMovieDetailBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        activityMovieDetailBinding= DataBindingUtil.setContentView(this,R.layout.activity_movie_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        if(intent!=null)
        {
            movie=intent.getParcelableExtra("movie_tag");
        }

        setValue();


    }

    private void setValue() {
        setTitle(movie.getOriginalTitle());
      //  Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
        activityMovieDetailBinding.setMovie(movie);

    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}