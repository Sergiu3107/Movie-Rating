package com.proj.movie_rating.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean("userBean")
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User user1 = new User(
                    "user1",
                    "pass1",
                    "this1@gmail.com",
                    "regular"
            );

            User user2 = new User(
                    "user2",
                    "pass2",
                    "this2@gmail.com",
                    "regular"
            );

            User user3 = new User(
                    "user3",
                    "pass3",
                    "this3@gmail.com",
                    "regular"
            );

            User admin1 = new User(
                    "admin1",
                    "adminpass",
                    "admin1@gmail.com",
                    "admin"
            );



            repository.saveAll(List.of(user1, user2, user3, admin1));

        };
    }
}
