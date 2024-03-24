package com.proj.movie_rating.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User user1 = new User(
                    "user1",
                    "pass1",
                    "this1@gmail.com",
                    "regular"
            );

            repository.saveAll(List.of(user1));

        };
    }
}
