package com.proj.movie_rating.controller;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * HTTP method: GET, for getting all the movies
     * @return a list of movies
     */
    @GetMapping("/show/all")
    public List<Movie> showAllMovies(){
        return movieService.getAllMovies();
    }

    /**
     * HTTP method: DETELE, for deleting the movie with a certain id
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeMovie(@PathVariable("id") Integer id){
        return movieService.deleteAMovie(id);
    }

    /**
     * HTTP method: POST, for adding a new movie
     * @param movie
     */
    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie){
        movieService.postMovie(movie);
    }

    /**
     * HTTP method: PUT, for updating a movie by id
     * @param id
     * @param movie
     */
    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable("id") Integer id,
                            @RequestBody Movie movie){
        movieService.putMovie(id, movie);
    }
}
