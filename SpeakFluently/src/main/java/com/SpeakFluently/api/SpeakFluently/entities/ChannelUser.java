package com.SpeakFluently.api.SpeakFluently.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "td_channel_users")
@Data
public class ChannelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_users_id")
    private int id;

    @Column(name = "channel_id", nullable = false)
    private int channelId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin = false;
}
