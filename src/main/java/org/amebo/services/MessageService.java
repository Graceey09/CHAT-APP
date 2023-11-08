package org.amebo.services;

import org.amebo.data.models.Chat;
import org.amebo.dtos.SendMessageRequest;

public interface MessageService {
    void sendMessage(SendMessageRequest sendMessageRequest, Chat chat);
}
