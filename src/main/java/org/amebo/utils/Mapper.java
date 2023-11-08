package org.amebo.utils;

import org.amebo.data.models.User;
import org.amebo.dtos.RegisterUserRequest;
import org.amebo.dtos.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest){
        User user = new User();
        user.setEmail(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

    public static RegisterUserResponse map (User user){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(user.getEmail());
        registerUserResponse.setRegisterDate(DateTimeFormatter
                .ofPattern("EEEE dd/MMM/yyyy HH:mm:ss a")
                .format(LocalDateTime.now()));
        return registerUserResponse;
    }
}
