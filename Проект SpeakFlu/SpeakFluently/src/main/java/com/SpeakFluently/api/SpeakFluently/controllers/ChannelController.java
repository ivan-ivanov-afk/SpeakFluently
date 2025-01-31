package com.SpeakFluently.api.SpeakFluently.controllers;

import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import com.SpeakFluently.api.SpeakFluently.http.AppResponse;
import com.SpeakFluently.api.SpeakFluently.services.ChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

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

    @GetMapping
    public ResponseEntity<?> fetchAllChannels() {
        var channels = channelService.getAllChannels();
        return AppResponse.success()
                .withData(channels)
                .build();
    }

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
    @PutMapping("/restore/{channelId}")
    public ResponseEntity<?> restoreChannel(@PathVariable int channelId) {
        boolean isRestored = channelService.restoreChannel(channelId);
        if (isRestored) {
            return AppResponse.success()
                    .withMessage("Channel restored successfully")
                    .build();
        }
        return AppResponse.error()
                .withMessage("Channel not found or already active")
                .build();
    }
}