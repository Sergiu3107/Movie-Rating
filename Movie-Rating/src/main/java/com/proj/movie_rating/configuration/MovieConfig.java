package com.proj.movie_rating.configuration;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean("movieBean")
    CommandLineRunner commandLineRunner(MovieRepository repository) {
        return args -> {
            Movie oppenheimer = new Movie(
                    "Oppenheimer",
                    2023,
                    4.1f,
                    "Biography",
                    "Christopher Nolan",
                    "A dramatization of the life story of J. Robert Oppenheimer, the physicist who had a large hand in the development of the atomic bomb, thus helping end World War 2. We see his life from university days all the way to post-WW2, where his fame saw him embroiled in political machinations",
                    "no img"
            );

            Movie barbie = new Movie(
                    "Barbie: Dreamland Adventure",
                    2024,
                    3.2f,
                    "Animation",
                    "Jennifer Lee",
                    "Follow Barbie on her magical journey through Dreamland as she encounters new friends and overcomes challenges to save the kingdom from an evil sorceress.",
                    "no img"
            );

            Movie superMarioBros = new Movie(
                    "Super Mario: Mushroom Kingdom Heroes",
                    2023,
                    4.2f,
                    "Adventure",
                    "Brad Bird",
                    "Join Mario and his friends as they embark on a thrilling adventure to rescue Princess Peach from the clutches of Bowser and save the Mushroom Kingdom from chaos.",
                    "no img"
            );

            repository.saveAll(List.of(oppenheimer, barbie, superMarioBros));

        };
    }
}
