package com.proj.movie_rating.service_contract;

import com.proj.movie_rating.model.User;

import java.util.List;

public interface UserServiceContract {

    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByUsername(String username);
    public boolean deleteAUser(Integer id);
    public void postUser(User user);
    public boolean putUser(Integer id, User user);
}
