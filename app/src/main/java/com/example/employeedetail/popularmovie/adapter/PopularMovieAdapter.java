package com.example.employeedetail.popularmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.employeedetail.R;
import com.example.employeedetail.popularmovie.model.Movie;

import java.util.ArrayList;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.PopularMovieHolder>
{
    private ArrayList<Movie>movies;
    private Context context;

    public PopularMovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.movie_popular_list,parent,false);
        return new PopularMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieHolder holder, int position)
    {
        Movie movie=movies.get(position);
        holder.movieData(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public  static class PopularMovieHolder extends RecyclerView.ViewHolder
    {
        public TextView movieTitle,rating;
        public ImageView movieImage;

        public PopularMovieHolder(@NonNull View itemView) {
            super(itemView);
            movieImage=itemView.findViewById(R.id.iv_popular_movie_pic);
            movieTitle=itemView.findViewById(R.id.tv_movie_title);
            rating=itemView.findViewById(R.id.tv_rating);

        }

        public void movieData(Movie movie) {
            movieTitle.setText(movie.getOriginalTitle());
            rating.setText(String.valueOf(movie.getVoteAverage()));
            String imagePath="https://image.tmdb.org/t/p/w500"+movie.getPosterPath();
            Glide.with(itemView.getContext())
                    .load(imagePath)
                    .placeholder(R.drawable.loading)
                    .into(movieImage);

        }
    }
}
