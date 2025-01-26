package com.SpeakFluently.api.SpeakFluently.services;

import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import com.SpeakFluently.api.SpeakFluently.repositories.ChannelRepo;
import com.SpeakFluently.api.SpeakFluently.repositories.ChannelUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    private final ChannelRepo channelRepo;
    private final ChannelUserRepo channelUserRepo;

    public ChannelService(ChannelRepo channelRepo, ChannelUserRepo channelUserRepo) {
        this.channelRepo = channelRepo;
        this.channelUserRepo = channelUserRepo;
    }

    public boolean createChannel(Channel channel) {
        channelRepo.save(channel);
        return true;
    }

    public List<Channel> getAllChannels() {
        return channelRepo.findByIsActive(true);
    }

    public Channel getChannel(int channelId) {
        return channelRepo.findById(channelId).orElse(null);
    }

    public List<Channel> getChannelsByUser(String username) {
        var channelUsers = channelUserRepo.findByUsername(username);
        return channelUsers.stream()
                .map(channelUser -> channelRepo.findById(channelUser.getChannelId()).orElse(null))
                .filter(java.util.Objects::nonNull)
                .collect(Collectors.toList());
    }

    public boolean updateChannel(Channel channel) {
        channelRepo.save(channel);
        return true;
    }

    public boolean removeChannel(int channelId) {
        Channel channel = getChannel(channelId);
        if (channel != null) {
            channel.setIsActive(false);
            channelRepo.save(channel);
            return true;
        }
        return false;
    }
}