package com.SpeakFluently.api.SpeakFluently.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

    // Getter and Setter for channelId
    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    // Getter and Setter for channelName
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    // Getter and Setter for channelOwnerUsername
    public String getChannelOwnerUsername() {
        return channelOwnerUsername;
    }

    public void setChannelOwnerUsername(String channelOwnerUsername) {
        this.channelOwnerUsername = channelOwnerUsername;
    }

    // Getter and Setter for isActive
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}