package com.yt.graphql.controllers;

import com.yt.graphql.entities.User;
import com.yt.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create user api
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    // get users
    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get single user
    @QueryMapping
    public User getUser(@Argument int userId) {
        return userService.getUser(userId);
    }

    //delete user
    @MutationMapping
    public boolean deleteUser(int userId) {
        return userService.deleteUser(userId);
    }
}
