package com.proj.movie_rating.movie;

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

    @GetMapping("/show/all")
    public List<Movie> showAllMovies(){
        return movieService.getAllMovies();
    }

    @DeleteMapping("/remove/{id}")
    public boolean removeMovie(@PathVariable("id") Integer id){
        return movieService.deleteAMovie(id);
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie){
        movieService.postMovie(movie);
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable("id") Integer id,
                            @RequestBody Movie movie){
        movieService.putMovie(id, movie);
    }
}
