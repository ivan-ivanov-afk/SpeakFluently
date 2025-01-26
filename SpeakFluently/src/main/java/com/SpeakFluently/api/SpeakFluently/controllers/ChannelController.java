package com.SpeakFluently.api.SpeakFluently.controllers;

import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import com.SpeakFluently.api.SpeakFluently.http.AppResponse;
import com.SpeakFluently.api.SpeakFluently.services.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    // Create a new channel
    @PostMapping
    public ResponseEntity<?> createChannel(@RequestBody Channel channel) {
        if (channelService.createChannel(channel)) {
            return AppResponse.success()
                    .withMessage("Channel created successfully")
                    .build();
        }
        return AppResponse.error()
                .withMessage("Channel creation failed")
                .build();
    }

    // Fetch all channels
    @GetMapping
    public ResponseEntity<?> fetchAllChannels() {
        var channels = channelService.getAllChannels();
        return AppResponse.success()
                .withData(channels)
                .build();
    }

    // Fetch a single channel by ID
    @GetMapping("/{channelId}")
    public ResponseEntity<?> fetchSingleChannel(@PathVariable int channelId) {
        var channel = channelService.getChannel(channelId); // Използвай getChannel вместо getChannelById

        if (channel == null) {
            return AppResponse.error()
                    .withMessage("Channel not found")
                    .build();
        }

        return AppResponse.success()
                .withData(channel)
                .build();
    }

    // Update a channel
    @PutMapping
    public ResponseEntity<?> updateChannel(@RequestBody Channel channel) {
        boolean isUpdateSuccessful = channelService.updateChannel(channel);

        if (!isUpdateSuccessful) {
            return AppResponse.error()
                    .withMessage("Channel update failed")
                    .build();
        }

        return AppResponse.success()
                .withMessage("Channel updated successfully")
                .build();
    }

    // Delete a channel by ID
    @DeleteMapping("/{channelId}")
    public ResponseEntity<?> removeChannel(@PathVariable int channelId) {
        boolean isDeleteSuccessful = channelService.removeChannel(channelId);

        if (!isDeleteSuccessful) {
            return AppResponse.error()
                    .withMessage("Channel not found or could not be deleted")
                    .build();
        }

        return AppResponse.success()
                .withMessage("Channel removed successfully")
                .build();
    }
}