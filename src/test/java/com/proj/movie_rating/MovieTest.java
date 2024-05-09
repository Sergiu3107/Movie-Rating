package com.proj.movie_rating;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import com.proj.movie_rating.service.MovieService;
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

public class MovieTest {

    @Mock
    private MovieRepository movieRepoMock;

    @InjectMocks
    private MovieService movieService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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

        // Calling the service method
        List<Movie> movieList = movieService.getAllMovies();

        // Verifying if the method was called and returned the correct value
        assertEquals(movies.size(), movieList.size());
        assertTrue(movieList.containsAll(movies));
    }

    @Test
    public void getMovieTest() {
        // Mocking MovieRepository's behavior
        Movie movie = new Movie(1, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img");
        when(movieRepoMock.findById(1)).thenReturn(Optional.of(movie));

        // Calling the service method
        Movie returnedMovie = movieService.getMovie(1);

        // Verifying if the method was called and returned the correct value
        assertNotNull(returnedMovie);
        assertEquals(movie, returnedMovie);
    }

    @Test
    public void deleteAMovieTest() {
        // Mocking MovieRepository's behavior
        when(movieRepoMock.existsById(1)).thenReturn(true);

        // Calling the service method
        boolean result = movieService.deleteAMovie(1);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(movieRepoMock).deleteById(1);
    }

    @Test
    public void postMovieTest() {
        // Creating a movie
        Movie movie = new Movie(null, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img");

        // Calling the service method
        movieService.postMovie(movie);

        // Verifying if the save method of MovieRepository is called once
        verify(movieRepoMock, times(1)).save(movie);
    }

    @Test
    public void putMovieTest() {
        // Mocking MovieRepository's behavior
        Movie movie = new Movie(1, "Oppenheimer", 2023, 4.1f, "Biography", "Christopher Nolan", "desc", "img");
        when(movieRepoMock.existsById(1)).thenReturn(true);
        when(movieRepoMock.findById(1)).thenReturn(Optional.of(movie));

        // Updating movie details
        Movie updatedMovie = new Movie(null, "Updated Movie", 2024, 4.2f, "Updated Genre", "Updated Director", "Updated Description", "Updated Image");

        // Calling the service method
        boolean result = movieService.putMovie(1, updatedMovie);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(movieRepoMock).save(movie);
        assertEquals(updatedMovie.getTitle(), movie.getTitle());
        assertEquals(updatedMovie.getReleaseYear(), movie.getReleaseYear());
        assertEquals(updatedMovie.getRating(), movie.getRating());
        assertEquals(updatedMovie.getGenre(), movie.getGenre());
        assertEquals(updatedMovie.getDirector(), movie.getDirector());
        assertEquals(updatedMovie.getDescription(), movie.getDescription());
        assertEquals(updatedMovie.getImage(), movie.getImage());
    }
}
