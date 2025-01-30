package com.SpeakFluently.api.SpeakFluently.repositories;

import com.SpeakFluently.api.SpeakFluently.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username); // Нов метод за проверка
}