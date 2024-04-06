package com.proj.movie_rating.configuration;

import com.proj.movie_rating.model.*;
import com.proj.movie_rating.repository.MovieRepository;
import com.proj.movie_rating.repository.ReviewRepository;
import com.proj.movie_rating.repository.UserRepository;
import com.proj.movie_rating.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReviewConfig {

    @Bean("reviewBean")
    CommandLineRunner commandLineRunner(ReviewRepository repository, MovieRepository movieRepository, UserRepository userRepository) {
        return args -> {

            Movie movie1 = movieRepository.findById(1).orElse(null);
            Movie movie2 = movieRepository.findById(2).orElse(null);
            Movie movie3 = movieRepository.findById(3).orElse(null);

            User user1 = userRepository.findById(1).orElse(null);
            System.out.println(user1);
            User user2  = userRepository.findById(2).orElse(null);

            Review review1 = new Review(
                    user1,
                    movie1,
                    4.5f,
                    "nice"
            );

            Review review2 = new Review(
                    user1,
                    movie2,
                    4.0f,
                    "eh eh nice"
            );

            Review review3 = new Review(
                    user2,
                    movie3,
                    5.0f,
                    "best"
            );



            repository.saveAll(List.of(review1, review2, review3));

        };
    }
}
