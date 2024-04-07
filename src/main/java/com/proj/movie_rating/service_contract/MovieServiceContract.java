package com.proj.movie_rating.service_contract;

import com.proj.movie_rating.model.Movie;

import java.util.List;

public interface MovieServiceContract {

    public List<Movie> getAllMovies();
    public Movie getMovie(int id);
    public boolean deleteAMovie(Integer id);
    public void postMovie(Movie movie);
    public boolean putMovie(Integer id, Movie movie);
}
