package com.yt.graphql.services;

import com.yt.graphql.entities.User;
import com.yt.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("Resource Not Found"));
        return user;
    }

    public boolean deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("Resource Not Found"));
        userRepo.delete(user);
        return true;
    }
}
