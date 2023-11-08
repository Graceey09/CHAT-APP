package org.amebo.services;

import org.amebo.data.models.Chat;
import org.amebo.data.models.Message;
import org.amebo.data.repository.MessageRepository;
import org.amebo.dtos.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;
    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest, Chat chat) {
        Message message = new Message();
        message.setBody(sendMessageRequest.getMessageBody());
        message.setChatId(chat.getId());
        message.setRead(false);
        message.setDateCreated(sendMessageRequest.getDateSent());
        messageRepository.save(message);

    }
}
