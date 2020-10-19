package com.example.employeedetail.popularmovie.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.employeedetail.R;
import com.example.employeedetail.popularmovie.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;
    private ImageView movieImageView;
    private TextView title,releaseDate,rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        if(intent!=null)
        {
            movie= (Movie)intent.getParcelableExtra("movie_tag");
        }
        initView();
        setValue();


    }

    private void setValue() {
       String imagePath="https://image.tmdb.org/t/p/w500"+movie.getPosterPath();
        Glide.with(getApplicationContext())
                .load(imagePath)
                .placeholder(R.drawable.loading)
                .into(movieImageView);
      //  Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
        title.setText(movie.getOriginalTitle());
        releaseDate.setText(movie.getReleaseDate());
        rating.setText(String.valueOf(movie.getVoteAverage()));
    }

    private void initView() {
        movieImageView=findViewById(R.id.iv_movie_large);
        title=findViewById(R.id.tv_movie_detail_title);
        rating=findViewById(R.id.tv_movie_rating);
        releaseDate=findViewById(R.id.tv_movie_release_date);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}