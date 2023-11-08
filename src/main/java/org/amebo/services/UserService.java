package org.amebo.services;

import org.amebo.data.models.Chat;
import org.amebo.data.models.User;
import org.amebo.dtos.CreateChatRequest;
import org.amebo.dtos.RegisterUserRequest;
import org.amebo.dtos.RegisterUserResponse;
import org.amebo.dtos.SendMessageRequest;

public interface UserService {
    RegisterUserResponse registerWith(RegisterUserRequest registerUserRequest);

    Chat createdChat(CreateChatRequest createChatRequest);
    User findByEmail(String username);
    void sendMessage(SendMessageRequest sendMessageRequest);
}
