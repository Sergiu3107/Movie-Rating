package com.proj.movie_rating.configuration;

import com.proj.movie_rating.model.*;
import com.proj.movie_rating.repository.MovieRepository;
import com.proj.movie_rating.repository.ReviewRepository;
import com.proj.movie_rating.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class ReviewConfig {

    @Order(3)
    @Bean("reviewBean")
    CommandLineRunner commandLineRunner(ReviewRepository repository, MovieRepository movieRepository, UserRepository userRepository) {
        return args -> {
            List<Movie> movies = movieRepository.findAll();
            List<User> users = userRepository.findAll();

            if (movies.size() < 17 || users.size() < 11) {
                throw new IllegalStateException("Not enough movies or users found");
            }

            Review review1 = new Review(users.get(0), movies.get(0), 4.5f, "Fantastic movie", 20);
            Review review2 = new Review(users.get(1), movies.get(0), 4.0f, "Great story", 15);
            Review review3 = new Review(users.get(2), movies.get(0), 5.0f, "Loved it!", 34);

            Review review4 = new Review(users.get(3), movies.get(1), 4.2f, "Very enjoyable", 10);
            Review review5 = new Review(users.get(4), movies.get(1), 4.7f, "Amazing visuals", 18);
            Review review6 = new Review(users.get(5), movies.get(1), 4.9f, "Superb animation", 27);

            Review review7 = new Review(users.get(6), movies.get(2), 3.8f, "Pretty good", 22);
            Review review8 = new Review(users.get(7), movies.get(2), 4.3f, "Nice horror elements", 16);
            Review review9 = new Review(users.get(8), movies.get(2), 4.6f, "Scary!", 19);

            Review review10 = new Review(users.get(9), movies.get(3), 4.0f, "Well directed", 12);
            Review review11 = new Review(users.get(10), movies.get(3), 4.5f, "Tarantino at his best", 23);
            Review review12 = new Review(users.get(0), movies.get(3), 4.8f, "Incredible", 31);

            Review review13 = new Review(users.get(1), movies.get(4), 5.0f, "Masterpiece", 40);
            Review review14 = new Review(users.get(2), movies.get(4), 4.7f, "Thrilling", 22);
            Review review15 = new Review(users.get(3), movies.get(4), 4.9f, "Excellent", 30);

            Review review16 = new Review(users.get(4), movies.get(5), 4.4f, "Fun for all ages", 11);
            Review review17 = new Review(users.get(5), movies.get(5), 4.5f, "Enjoyed it", 25);
            Review review18 = new Review(users.get(6), movies.get(5), 4.6f, "Very entertaining", 28);

            Review review19 = new Review(users.get(7), movies.get(6), 4.3f, "Fantastic Mr. Fox indeed", 13);
            Review review20 = new Review(users.get(8), movies.get(6), 4.2f, "Loved the animation style", 20);
            Review review21 = new Review(users.get(9), movies.get(6), 4.1f, "Great for kids", 17);

            Review review22 = new Review(users.get(10), movies.get(7), 4.9f, "Mind-bending", 33);
            Review review23 = new Review(users.get(0), movies.get(7), 4.8f, "Incredible storytelling", 29);
            Review review24 = new Review(users.get(1), movies.get(7), 4.7f, "Best of the year", 24);

            Review review25 = new Review(users.get(2), movies.get(8), 4.0f, "Classic", 18);
            Review review26 = new Review(users.get(3), movies.get(8), 4.1f, "Timeless", 14);
            Review review27 = new Review(users.get(4), movies.get(8), 4.2f, "Must watch", 19);

            Review review28 = new Review(users.get(5), movies.get(9), 4.9f, "Scorsese's best", 35);
            Review review29 = new Review(users.get(6), movies.get(9), 4.8f, "Gripping", 27);
            Review review30 = new Review(users.get(7), movies.get(9), 4.7f, "Classic crime film", 26);

            Review review31 = new Review(users.get(8), movies.get(10), 4.8f, "Tarantino's masterpiece", 30);
            Review review32 = new Review(users.get(9), movies.get(10), 4.9f, "Iconic", 38);
            Review review33 = new Review(users.get(10), movies.get(10), 4.7f, "Unforgettable", 32);

            Review review34 = new Review(users.get(0), movies.get(11), 4.5f, "Intense", 23);
            Review review35 = new Review(users.get(1), movies.get(11), 4.6f, "Brilliant", 21);
            Review review36 = new Review(users.get(2), movies.get(11), 4.4f, "A must-watch", 16);

            Review review37 = new Review(users.get(3), movies.get(12), 5.0f, "Amazing animation", 39);
            Review review38 = new Review(users.get(4), movies.get(12), 4.9f, "Beautiful story", 37);
            Review review39 = new Review(users.get(5), movies.get(12), 4.8f, "Miyazaki's best", 31);

            Review review40 = new Review(users.get(6), movies.get(13), 4.7f, "Timeless classic", 28);
            Review review41 = new Review(users.get(7), movies.get(13), 4.6f, "Fun and exciting", 22);
            Review review42 = new Review(users.get(8), movies.get(13), 4.5f, "Back in time", 20);

            Review review43 = new Review(users.get(9), movies.get(14), 4.4f, "Nolan's brilliance", 15);
            Review review44 = new Review(users.get(10), movies.get(14), 4.3f, "Historical drama", 14);
            Review review45 = new Review(users.get(0), movies.get(14), 4.5f, "Epic", 18);

            Review review46 = new Review(users.get(1), movies.get(15), 4.0f, "Heartwarming", 12);
            Review review47 = new Review(users.get(2), movies.get(15), 4.1f, "Lovely", 13);
            Review review48 = new Review(users.get(3), movies.get(15), 4.2f, "Well made", 19);

            Review review49 = new Review(users.get(4), movies.get(16), 5.0f, "Best ever", 40);
            Review review50 = new Review(users.get(5), movies.get(16), 4.9f, "Inspiring", 37);
            Review review51 = new Review(users.get(6), movies.get(16), 4.8f, "Brilliant", 36);

            repository.saveAll(List.of(
                    review1, review2, review3, review4, review5, review6, review7, review8, review9,
                    review10, review11, review12, review13, review14, review15, review16, review17,
                    review18, review19, review20, review21, review22, review23, review24, review25,
                    review26, review27, review28, review29, review30, review31, review32, review33,
                    review34, review35, review36, review37, review38, review39, review40, review41,
                    review42, review43, review44, review45, review46, review47, review48, review49,
                    review50, review51
            ));

            List<Review> reviews = repository.findAll();
            for (Review review : reviews) {
                review.registerObserver(review.getUser());
            }
        };
    }
}
