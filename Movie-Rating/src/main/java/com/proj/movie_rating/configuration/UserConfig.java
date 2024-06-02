package com.proj.movie_rating.configuration;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class UserConfig {

    @Order(2)
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

            User user4 = new User(
                    "user4",
                    "pass4",
                    "this4@gmail.com",
                    "regular"
            );

            User user5 = new User(
                    "user5",
                    "pass5",
                    "this5@gmail.com",
                    "regular"
            );

            User user6 = new User(
                    "user6",
                    "pass6",
                    "this6@gmail.com",
                    "regular"
            );

            User user7 = new User(
                    "user7",
                    "pass7",
                    "this7@gmail.com",
                    "regular"
            );

            User user8 = new User(
                    "user8",
                    "pass8",
                    "this8@gmail.com",
                    "regular"
            );

            User user9 = new User(
                    "user9",
                    "pass9",
                    "this9@gmail.com",
                    "regular"
            );

            User user10 = new User(
                    "user10",
                    "pass10",
                    "this10@gmail.com",
                    "regular"
            );

            User admin1 = new User(
                    "admin1",
                    "adminpass",
                    "admin1@gmail.com",
                    "admin"
            );

            repository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, admin1));
        };
    }
}
