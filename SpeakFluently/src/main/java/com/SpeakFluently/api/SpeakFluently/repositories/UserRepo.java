package com.SpeakFluently.api.SpeakFluently.repositories;

import com.SpeakFluently.api.SpeakFluently.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    List<User> findByIsActive(boolean isActive);
    User findByUsernameAndIsActive(String username, boolean isActive); // Fixed missing method
}