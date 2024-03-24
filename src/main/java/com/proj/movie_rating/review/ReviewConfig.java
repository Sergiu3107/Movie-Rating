package com.proj.movie_rating.review;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReviewConfig {

    @Bean("reviewBean")
    CommandLineRunner commandLineRunner(ReviewRepository repository) {
        return args -> {
            Review review1 = new Review(
                    1,
                    1,
                    4.5f,
                    "nice"
            );

            Review review2 = new Review(
                    1,
                    2,
                    4.0f,
                    "eh eh nice"
            );

            Review review3 = new Review(
                    2,
                    3,
                    5.0f,
                    "best"
            );



            repository.saveAll(List.of(review1, review2, review3));

        };
    }
}
