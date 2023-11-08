package org.amebo.services;

import org.amebo.data.models.Chat;
import org.amebo.data.repository.ChatRepository;
import org.amebo.dtos.FindChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService{
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public void createChat(Chat chat) {
        chatRepository.save(chat);

    }

    @Override
    public Chat findChat(FindChatRequest findChatRequest) {
        Optional<Chat> chat = chatRepository
                .findChatByChatNameAndParticipantContains(
                        findChatRequest.getFirstChatNmae(),
                        findChatRequest.getParticipant());

        if(chat.isPresent()) return chat.get();
        Optional<Chat> sameChat = checkRepositoryAgain(findChatRequest);
        return sameChat.orElse(null);
    }

    private Optional<Chat> checkRepositoryAgain(FindChatRequest findChatRequest){
        return chatRepository
                .findChatByChatNameAndParticipantContains(
                        findChatRequest.getSecondChatNmae(),
                        findChatRequest.getParticipant());
    }
}
