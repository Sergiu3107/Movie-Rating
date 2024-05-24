package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepoMock;

    @InjectMocks
    private MovieService movieService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getMovieTest() {

        Movie movie = new Movie(1, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img");
        when(movieRepoMock.findById(1)).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovie(1);

        assertEquals(result, movie);
        verify(movieRepoMock).findById(1);
    }

    @Test
    public void getAllMoviesTest() {
        // Mocking MovieRepository's behavior
        List<Movie> movies = Arrays.asList(
                new Movie(1, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img"),
                new Movie(2, "Barbie: Dreamland Adventure", 2024, 3.2f, "Animation", "Jennifer Lee", "desc", "img"),
                new Movie(3, "Super Mario: Mushroom Kingdom Heroes", 2023, 4.2f, "Adventure", "Brad Bird", "desc", "img")
        );

        when(movieRepoMock.findAll()).thenReturn(movies);

        List<Movie> result = movieService.getAllMovies();

        assertEquals(result, movies);
        verify(movieRepoMock).findAll();
    }

    @Test
    public void deleteAMovieTest() {

        when(movieRepoMock.existsById(1)).thenReturn(true);

        boolean result = movieService.deleteAMovie(1);

        assertTrue(result);
        verify(movieRepoMock).deleteById(1);
    }

    @Test
    public void postMovieTest() {

        Movie movieTest = new Movie(100, "Interstellar", 2021, 4.9f, "Biography", "Christopher Nolan", "desc", "img");
        when(movieRepoMock.save(movieTest)).thenReturn(movieTest);

        movieService.postMovie(movieTest);
        verify(movieRepoMock).save(movieTest);
    }

    @Test
    public void putMovieTest() {

        Movie movie = new Movie(1, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img");

        when(movieRepoMock.existsById(1)).thenReturn(true);
        when(movieRepoMock.findById(1)).thenReturn(Optional.of(movie));

        Movie updatedMovie = new Movie(null, "Updated Movie", 2024, 4.2f, "Updated Genre", "Updated Director", "Updated Description", "Updated Image");
        boolean result = movieService.putMovie(1, updatedMovie);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(movieRepoMock).save(movie);

    }

    @Test
    public void updateReleaseYearTest(){

        Movie updatedMovie = new Movie(null, "Updated Movie", 2024, 4.2f, "Updated Genre", "Updated Director", "Updated Description", "Updated Image");
        movieService.putMovie(1, updatedMovie);

        Movie movie = movieService.getMovie(1);

        assertEquals(movie.getReleaseYear(), updatedMovie.getReleaseYear());
    }

    @Test
    public void updateRatingTest(){

        Movie updatedMovie = new Movie(null, "Updated Movie", 2024, 4.2f, "Updated Genre", "Updated Director", "Updated Description", "Updated Image");
        movieService.putMovie(1, updatedMovie);

        Movie movie = movieService.getMovie(1);

        assertEquals(movie.getRating(), updatedMovie.getRating());
    }
}
