package com.SpeakFluently.api.SpeakFluently.system;

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