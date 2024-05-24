package com.proj.movie_rating.controller;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.service.MovieService;
import com.proj.movie_rating.service_contract.MovieServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieServiceContract movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves all movies.
     *
     * @return A list of all movies.
     */
    @GetMapping("/show/all")
    public List<Movie> showAllMovies(){
        return movieService.getAllMovies();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return The movie with the specified ID.
     */
    @GetMapping("/show/{id}")
    public  Movie showMovie(@PathVariable("id") int id){
        return movieService.getMovie(id);
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id The ID of the movie to delete.
     * @return true if the movie was successfully deleted, false otherwise.
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeMovie(@PathVariable("id") Integer id){
        return movieService.deleteAMovie(id);
    }

    /**
     * Adds a new movie.
     *
     * @param movie The movie object to add.
     */
    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie){
        movieService.postMovie(movie);
    }

    /**
     * Updates a movie with the specified ID.
     *
     * @param id The ID of the movie to update.
     * @param movie The updated movie object.
     */
    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable("id") Integer id,
                            @RequestBody Movie movie){
        movieService.putMovie(id, movie);
    }
}
