package com.SpeakFluently.api.SpeakFluently.repositories;

import com.SpeakFluently.api.SpeakFluently.entities.ChannelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelUserRepo extends JpaRepository<ChannelUser, Integer> {
    List<ChannelUser> findByUsername(String username);
}