package com.example.employeedetail.popularmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.databinding.MoviePopularListBindingImpl;
import com.example.employeedetail.popularmovie.listener.MovieListener;
import com.example.employeedetail.popularmovie.model.Movie;

import java.util.ArrayList;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.PopularMovieHolder>
{
    private ArrayList<Movie>movies;
    private Context context;
    private MovieListener movieListener;

    public PopularMovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
        this.movieListener= (MovieListener) context;
    }

    @NonNull
    @Override
    public PopularMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MoviePopularListBindingImpl moviePopularListBinding= DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.movie_popular_list,parent,false);
        return new PopularMovieHolder(moviePopularListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieHolder holder, int position)
    {
        Movie movie=movies.get(position);
        holder.movieData(movie,movieListener);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public  static class PopularMovieHolder extends RecyclerView.ViewHolder
    {
     private MoviePopularListBindingImpl binding;

        public PopularMovieHolder(@NonNull MoviePopularListBindingImpl moviePopularListBinding) {
            super(moviePopularListBinding.getRoot());
            this.binding=moviePopularListBinding;
        }

        public void movieData(Movie movie,MovieListener listener) {

            binding.setMovie(movie);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMovieClick(movie);
                }
            });
        }
    }
}
