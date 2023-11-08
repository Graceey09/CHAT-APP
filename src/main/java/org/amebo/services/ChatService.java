package org.amebo.services;

import org.amebo.data.models.Chat;
import org.amebo.dtos.FindChatRequest;

public interface ChatService {
    void createChat(Chat chat);

    Chat findChat(FindChatRequest findChatRequest);
}
