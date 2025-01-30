package com.SpeakFluently.api.SpeakFluently.services;

import com.SpeakFluently.api.SpeakFluently.entities.User;
import com.SpeakFluently.api.SpeakFluently.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean createUser(User user) {
        userRepo.save(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    public boolean updateUser(User user) {
        if (userRepo.existsByUsername(user.getUsername())) { // Създаден метод в UserRepo
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public boolean removeUser(String username) {
        User user = getUserByUsername(username);
        if (user != null) {
            userRepo.delete(user);
            return true;
        }
        return false;
    }

}