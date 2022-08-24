package com.precious.diary.dataTransferObjects;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String userId;
    private String name;
    private String email;
    private String password;
}
