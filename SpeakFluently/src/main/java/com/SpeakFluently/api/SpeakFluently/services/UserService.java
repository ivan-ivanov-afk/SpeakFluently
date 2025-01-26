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
        if (userRepo.existsById(user.getUsername())) {
            return false;
        }
        userRepo.save(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepo.findByIsActive(true);
    }

    public User getUser(String username) {
        return userRepo.findByUsernameAndIsActive(username, true);
    }

    public boolean updateUser(User user) {
        if (!userRepo.existsById(user.getUsername())) {
            return false;
        }
        userRepo.save(user);
        return true;
    }

    public boolean removeUser(String username) {
        User user = getUser(username);
        if (user != null) {
            user.setIsActive(false);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
