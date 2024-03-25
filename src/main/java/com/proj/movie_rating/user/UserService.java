package com.proj.movie_rating.user;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Connection to the database's table: User
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Provide a list of all the users
     * @return list of users
     */
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
