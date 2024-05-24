package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import com.proj.movie_rating.service_contract.MovieServiceContract;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing operations related to the 'Movie' entity in the database.
 */
@Service
public class MovieService implements MovieServiceContract {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Retrieves a list of all movies.
     *
     * @return A list of all movies.
     */
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return The movie with the specified ID, or null if not found.
     */
    public Movie getMovie(int id){
        return movieRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a movie by its ID, if it exists.
     *
     * @param id The ID of the movie to delete.
     * @return true if the movie was successfully deleted, false otherwise.
     */
    public boolean deleteAMovie(Integer id){
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Inserts a new movie.
     *
     * @param movie The movie object to insert.
     */
    public void postMovie(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     * Modifies the movie with the specified ID by updating its release year and rating, if it exists.
     *
     * @param id    The ID of the movie to update.
     * @param movie The updated movie object.
     * @return true if the movie was successfully updated, false otherwise.
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
