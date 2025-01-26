package com.SpeakFluently.api.SpeakFluently.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "td_channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private int channelId;

    @Column(name = "channel_name", nullable = false, length = 50)
    private String channelName;

    @Column(name = "channel_owner_username", nullable = false, length = 50)
    private String channelOwnerUsername;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    // Getters and Setters
    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelOwnerUsername() {
        return channelOwnerUsername;
    }

    public void setChannelOwnerUsername(String channelOwnerUsername) {
        this.channelOwnerUsername = channelOwnerUsername;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
