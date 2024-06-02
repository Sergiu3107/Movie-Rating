package com.proj.movie_rating.controller;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.service.UserService;
import com.proj.movie_rating.service_contract.UserServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserServiceContract userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    @GetMapping("/show/all")
    public List<User> showAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID.
     */
    @GetMapping("/show/by_id/{id}")
    public  User showUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    /**
     * Retrieves a user by its Username.
     *
     * @param username The username of the user to retrieve.
     * @return The user with the specified username.
     */
    @GetMapping("/show/by_name/{username}")
    public  User showUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id The ID of the user to delete.
     * @return true if the user was successfully deleted, false otherwise.
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeUser(@PathVariable("id") Integer id){
        return userService.deleteAUser(id);
    }

    /**
     * Adds a new user.
     *
     * @param user The user object to add.
     */
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.postUser(user);
    }

    /**
     * Updates a user with the specified ID.
     *
     * @param id   The ID of the user to update.
     * @param user The updated user object.
     */
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") Integer id,
                           @RequestBody User user){
        userService.putUser(id, user);
    }
}
