package com.proj.movie_rating.controller;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * HTTP method: GET, for getting all the users
     * @return a list of users
     */
    @GetMapping("/show/all")
    public List<User> showAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/show/{id}")
    public  User showUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    /**
     * HTTP method: DETELE, for deleting the user with a certain id
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeUser(@PathVariable("id") Integer id){
        return userService.deleteAUser(id);
    }

    /**
     * HTTP method: POST, for adding a new user
     * @param user
     */
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.postUser(user);
    }

    /**
     * HTTP method: PUT, for updating a user by id
     * @param id
     * @param user
     */
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") Integer id,
                            @RequestBody User user){
        userService.putUser(id, user);
    }
}
