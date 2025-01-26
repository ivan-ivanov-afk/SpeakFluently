package com.SpeakFluently.api.SpeakFluently.system;
import com.SpeakFluently.api.SpeakFluently.entities.User;
import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import com.SpeakFluently.api.SpeakFluently.repositories.UserRepo;
import com.SpeakFluently.api.SpeakFluently.repositories.ChannelRepo;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
@Component
public class DataInit {

    private final UserRepo userRepo;
    private final ChannelRepo channelRepo;

    public DataInit(UserRepo userRepo, ChannelRepo channelRepo) {
        this.userRepo = userRepo;
        this.channelRepo = channelRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDatabase() {
        // Създаване на примерни записи
        if (userRepo.count() == 0) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin123");
            user.setFullname("Administrator");
            userRepo.save(user);
        }

        if (channelRepo.count() == 0) {
            Channel channel = new Channel();
            channel.setChannelName("General");
            channel.setChannelOwnerUsername("admin");
            channelRepo.save(channel);
        }
    }
}