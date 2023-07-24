package com.sharad.ridersspot.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "user")
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
}
