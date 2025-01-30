package com.SpeakFluently.api.SpeakFluently.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "td_users")
public class User {

    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;

    @Column(name = "is_active", nullable = false)
    private int isActive = 1;

    @Column(name = "role", nullable = false, length = 20)
    private String role = "GUEST"; // Default role
}