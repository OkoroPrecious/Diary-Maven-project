package com.precious.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
@Data
public class User {
    private String name;
    private String email;
    private String password;
    @DBRef
    private Diary diary;
    @Id
    private String userId;
}
