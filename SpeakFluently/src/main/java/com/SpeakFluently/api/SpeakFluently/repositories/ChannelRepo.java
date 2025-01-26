package com.SpeakFluently.api.SpeakFluently.repositories;


import com.SpeakFluently.api.SpeakFluently.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Integer> {
    List<Channel> findByIsActive(boolean isActive);
}