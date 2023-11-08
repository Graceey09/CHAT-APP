package org.amebo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User {

    @Id
    private String id;
    private String email;
    private String password;
}
