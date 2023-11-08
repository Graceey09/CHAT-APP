package org.amebo.dtos;


import lombok.Data;
import org.amebo.data.models.User;

import java.util.List;

@Data
public class FindChatRequest {
    private String firstChatNmae;
    private String secondChatNmae;
    private List<User> participant;
}
