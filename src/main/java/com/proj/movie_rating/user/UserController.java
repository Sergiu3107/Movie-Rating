package com.proj.movie_rating.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
