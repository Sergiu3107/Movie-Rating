package com.proj.movie_rating.movie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public boolean deleteAMovie(Integer id){
        if(movieRepository.existsById(id)) {
            System.out.println("Deleted");
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void postMovie(Movie movie) {
        movieRepository.save(movie);
    }

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
