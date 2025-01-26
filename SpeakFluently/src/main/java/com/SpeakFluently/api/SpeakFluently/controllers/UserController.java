package com.SpeakFluently.api.SpeakFluently.controllers;

import com.SpeakFluently.api.SpeakFluently.entities.User;
import com.SpeakFluently.api.SpeakFluently.http.AppResponse;
import com.SpeakFluently.api.SpeakFluently.services.UserService;
import com.SpeakFluently.api.SpeakFluently.services.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ChannelService channelService;

    // Create new user
    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        if (userService.createUser(user)) {
            return AppResponse.success()
                    .withMessage("User created successfully")
                    .build();
        }
        return AppResponse.error()
                .withMessage("User could not be created")
                .build();
    }

    // Fetch all users
    @GetMapping
    public ResponseEntity<?> fetchAllUsers() {
        List<User> users = userService.getAllUsers();
        return AppResponse.success()
                .withData(users)
                .build();
    }

    // Fetch single user by username
    @GetMapping("/{username}")
    public ResponseEntity<?> fetchSingleUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return AppResponse.error()
                    .withMessage("User data not found")
                    .build();
        }
        return AppResponse.success()
                .withData(user)
                .build();
    }

    // Update user
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        boolean isUpdated = userService.updateUser(user);
        if (!isUpdated) {
            return AppResponse.error()
                    .withMessage("User data not found")
                    .build();
        }
        return AppResponse.success()
                .withMessage("Update successful")
                .build();
    }


    // Delete user
    @DeleteMapping("/{username}")
    public ResponseEntity<?> removeUser(@PathVariable String username) {
        boolean isDeleted = userService.removeUser(username);
        if (!isDeleted) {
            return AppResponse.error()
                    .withMessage("User not found")
                    .build();
        }
        return AppResponse.success()
                .withMessage("Remove successful")
                .build();
    }
}
