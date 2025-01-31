package com.SpeakFluently.api.SpeakFluently.services;

import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import com.SpeakFluently.api.SpeakFluently.repositories.ChannelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    private final ChannelRepo channelRepo;

    public ChannelService(ChannelRepo channelRepo) {
        this.channelRepo = channelRepo;
    }


    public boolean createChannel(Channel channel) {
        channel.setDeleted(false); // По подразбиране новите канали не са изтрити
        channelRepo.save(channel);
        return true;
    }


    public List<Channel> getAllChannels() {
        return channelRepo.findByIsDeletedFalse();
    }


    public Optional<Channel> getChannel(int channelId) {
        return channelRepo.findById(channelId);
    }


    public boolean updateChannel(Channel channel) {
        channelRepo.save(channel);
        return true;
    }


    public boolean removeChannel(int channelId) {
        Optional<Channel> channel = getChannel(channelId);
        if (channel.isPresent()) {
            Channel existingChannel = channel.get();
            existingChannel.setDeleted(true); // Soft delete
            channelRepo.save(existingChannel);
            return true;
        }
        return false;
    }


    public boolean restoreChannel(int channelId) {
        Optional<Channel> channel = getChannel(channelId);
        if (channel.isPresent() && channel.get().isDeleted()) {
            Channel existingChannel = channel.get();
            existingChannel.setDeleted(false); // Възстановяване
            channelRepo.save(existingChannel);
            return true;
        }
        return false;
    }
}
