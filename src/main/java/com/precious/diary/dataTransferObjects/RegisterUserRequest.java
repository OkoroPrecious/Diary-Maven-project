package com.precious.diary.dataTransferObjects;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
