package org.amebo.data.repository;

import org.amebo.data.models.Chat;
import org.amebo.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends MongoRepository<Chat, String> {
    Optional<Chat> findChatByChatNameAndParticipantContains(String chatName, List<User> participant);
}
