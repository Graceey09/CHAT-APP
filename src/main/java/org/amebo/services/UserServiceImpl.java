//package org.amebo.services;
//
//import org.amebo.data.models.Chat;
//import org.amebo.data.models.User;
//import org.amebo.data.repository.UserRepository;
//import org.amebo.dtos.CreateChatRequest;
//import org.amebo.dtos.RegisterUserRequest;
//import org.amebo.dtos.RegisterUserResponse;
//import org.amebo.dtos.SendMessageRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import static org.amebo.utils.Mapper.map;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private MessageService messageService;
//
//
//    @Override
//    public RegisterUserResponse registerWith(RegisterUserRequest registerUserRequest) {
//        findUser(registerUserRequest);
//        return map(userRepository.save(map(registerUserRequest)));
//    }
//
//    @Override
//    public Chat createdChat(CreateChatRequest createChatRequest) {
//        return null;
//    }
//
//    @Override
//    public Chat createChat(CreateChatRequest createChatRequest) {
//        Chat chat = new Chat();
//        chat.setChatName(createChatRequest.getFirstUser() + " "
//                + createChatRequest.getSecondUser());
//        chat.getParticipant().addAll(List
//                .of(findByEmail(createChatRequest.getFirstUser()), findByEmail(createChatRequest.getSecondUser())));
//        chatService.createChat(chat);
//        return chat;
//    }
//
//    private void findUser(RegisterUserRequest registerUserRequest) {
//        Optional<User> user = userRepository
//                .findByEmail(registerUserRequest.getUsername());
//        if(user.isPresent())
//            throw new UserAlreadyExistException("Username Already Exist");
//
//    }
//
//    public User findByEmail(String username) {
//        Optional<User> foundUser = userRepository.findByEmail(username);
//        if(foundUser.isPresent())
//            return foundUser.get();
//        throw new UserNotFoundException("User Not Found");
//    }
//
//    @Override
//    public void sendMessage(SendMessageRequest sendMessageRequest) {
//        CreateChatRequest createChatRequest = new CreateChatRequest();
//        createChatRequest.setFirstUser(sendMessageRequest.getFrom());
//        createChatRequest.setSecondUser(sendMessageRequest.getTo());
//
//        FindChatRequest findChatRequest = new FindChatRequest();
//        findChatRequest.setFirstChatName(sendMessageRequest.getFrom() + " " + sendMessageRequest.getTo());
//        findChatRequest.setSecondChatName(sendMessageRequest.getTo() + " " + sendMessageRequest.getFrom());
//        findChatRequest.setParticipant(List
//                .of(findByEmail(sendMessageRequest.getFrom()), findByEmail(sendMessageRequest.getTo())));
//        Chat chat = findChat(findChatRequest);
//
//        if (chat == null) chat = createChat(createChatRequest);
//        postMessage(sendMessageRequest, chat);
//    }
//
//
//    private void postMessage(SendMessageRequest sendMessageRequest, Chat chat) {
//        messageService.sendMessage(sendMessageRequest, chat);
//
//    }
//
//    private Chat findChat(FindChatRequest findChatRequest) {
//        return chatService.findChat(findChatRequest);
//    }
//
//}
