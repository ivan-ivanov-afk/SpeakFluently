package com.SpeakFluently.api.SpeakFluently.repositories;

import com.SpeakFluently.api.SpeakFluently.entities.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserMessageRepo extends JpaRepository<UserMessage, Integer> {
    List<UserMessage> findByReceiverUsername(String receiverUsername);
}
