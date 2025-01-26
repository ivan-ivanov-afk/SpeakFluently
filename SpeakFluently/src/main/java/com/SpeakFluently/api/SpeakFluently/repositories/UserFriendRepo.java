package com.SpeakFluently.api.SpeakFluently.repositories;


import com.SpeakFluently.api.SpeakFluently.entities.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserFriendRepo extends JpaRepository<UserFriend, Integer> {
    List<UserFriend> findByUsername(String username);
}
