package com.SpeakFluently.api.SpeakFluently.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "td_channel_messages")
public class ChannelMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sender_username", nullable = false, length = 50)
    private String senderUsername;

    @Column(name = "receiver_channel_id", nullable = false)
    private int receiverChannelId;

    @Column(name = "message", nullable = false, length = 256)
    private String message;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    // Getters and Setters
}