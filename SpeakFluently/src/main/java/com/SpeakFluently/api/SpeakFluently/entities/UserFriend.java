package com.SpeakFluently.api.SpeakFluently.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "td_user_friends")
public class UserFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "td_user_friends_id")
    private int id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "friend_username", nullable = false, length = 50) // Fixed typo
    private String friendUsername;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public void setFriendUsername(String friendUsername) {
        this.friendUsername = friendUsername;
    }
}