package com.SpeakFluently.api.SpeakFluently.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
