package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Connection to the database's table: Movie
 */
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Provide a list of all the movies
     * @return list of movies
     */
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(int id){
        return movieRepository.findById(id).orElse(null);
    }

    /**
     * Delete the movie by id, if it exists
     * @param id
     * @return true if movie with id is available, else false
     */
    public boolean deleteAMovie(Integer id){
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Insert a new movie
     * @param movie
     */
    public void postMovie(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     * Modify the movie with a certain id, by releaseYear and rating, if it exists
     * @param id
     * @param movie
     * @return
     */
    public boolean putMovie(Integer id, Movie movie) {
        if(movieRepository.existsById(id)) {
            Movie current =  movieRepository.findById(id).get();
            current.setReleaseYear(movie.getReleaseYear());
            current.setRating(movie.getRating());
            movieRepository.save(current);
            return true;
        }
        return false;
    }
}
