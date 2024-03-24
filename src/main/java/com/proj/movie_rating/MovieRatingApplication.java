package com.proj.movie_rating;

import com.proj.movie_rating.movie.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MovieRatingApplication {

	public static void main(String[] args) {

		SpringApplication.run(MovieRatingApplication.class, args);
	}

}
