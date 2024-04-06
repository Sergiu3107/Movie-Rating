package com.proj.movie_rating.service;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.repository.UserRepository;
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
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Delete the user by id, if it exists
     * @param id
     * @return true if user with id is available, else false
     */
    public boolean deleteAUser(Integer id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Insert a new user
     * @param user
     */
    public void postUser(User user) {
        userRepository.save(user);
    }

    /**
     * Modify the user with a certain id, by releaseYear and rating, if it exists
     * @param id
     * @param user
     * @return
     */
    public boolean putUser(Integer id, User user) {
        if(userRepository.existsById(id)) {
            User current =  userRepository.findById(id).get();
            current.setUsername(user.getUsername());
            current.setPassword(user.getPassword());
            userRepository.save(current);
            return true;
        }
        return false;
    }
}
