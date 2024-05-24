package com.proj.movie_rating.service;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.repository.UserRepository;
import com.proj.movie_rating.service_contract.UserServiceContract;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing operations related to the 'User' entity in the database.
 */
@Service
public class UserService implements UserServiceContract {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a user by its ID, if it exists.
     *
     * @param id The ID of the user to delete.
     * @return true if the user was successfully deleted, false otherwise.
     */
    public boolean deleteAUser(Integer id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Inserts a new user.
     *
     * @param user The user object to insert.
     */
    public void postUser(User user) {
        userRepository.save(user);
    }

    /**
     * Modifies the user with the specified ID by updating its username and password, if it exists.
     *
     * @param id   The ID of the user to update.
     * @param user The updated user object.
     * @return true if the user was successfully updated, false otherwise.
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
