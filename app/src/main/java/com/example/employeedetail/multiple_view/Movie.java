package com.example.employeedetail.multiple_view;

public class Movie {
    private int movieImage;
    private String movieName;
    private int movieRating;

    public Movie(int movieImage, String movieName, int movieRating) {
        this.movieImage = movieImage;
        this.movieName = movieName;
        this.movieRating = movieRating;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
