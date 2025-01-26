package com.SpeakFluently.api.SpeakFluently.controllers;

import com.SpeakFluently.api.SpeakFluently.entities.User;
import com.SpeakFluently.api.SpeakFluently.entities.ChannelUser;
import com.SpeakFluently.api.SpeakFluently.http.AppResponse;
import com.SpeakFluently.api.SpeakFluently.services.UserService;
import com.SpeakFluently.api.SpeakFluently.services.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class UserController {

    private final UserService userService;
    private final ChannelService channelService;

    public UserController(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;
    }

    // Create new user
    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        if (this.userService.createUser(user)) {
            return AppResponse.success()
                    .withMessage("User created successfully")
                    .build();
        }
        return AppResponse.error()
                .withMessage("User could not be created")
                .build();
    }

    // Fetch all users
    @GetMapping("/users")
    public ResponseEntity<?> fetchAllUsers() {
        ArrayList<User> collection = new ArrayList<>(this.userService.getAllUsers());
        return AppResponse.success()
                .withData(collection)
                .build();
    }

    // Fetch single user by username
    @GetMapping("/users/{username}")
    public ResponseEntity<?> fetchSingleUser(@PathVariable String username) {
        User responseUser = this.userService.getUser(username);
        if (responseUser == null) {
            return AppResponse.error()
                    .withMessage("User data not found")
                    .build();
        }
        return AppResponse.success()
                .withData(responseUser)
                .build();
    }

    // Fetch all channels for a user
    @GetMapping("/users/{username}/channels")
    public ResponseEntity<?> fetchAllChannelsForUser(@PathVariable String username) {
        var result = this.channelService.getChannelsByUser(username); // Fixed method name
        return AppResponse.success()
                .withMessage("Fetch successful")
                .withData(result)
                .build();
    }

    // Update user
    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        boolean isUpdateSuccessful = this.userService.updateUser(user);
        if (!isUpdateSuccessful) {
            return AppResponse.error()
                    .withMessage("User data not found")
                    .build();
        }
        return AppResponse.success()
                .withMessage("Update successful")
                .build();
    }

    // Delete user
    @DeleteMapping("/users/{username}")
    public ResponseEntity<?> removeUser(@PathVariable String username) {
        boolean isDeleteSuccessful = this.userService.removeUser(username);
        if (!isDeleteSuccessful) {
            return AppResponse.error()
                    .withMessage("User not found")
                    .build();
        }
        return AppResponse.success()
                .withMessage("Remove successful")
                .build();
    }
}
