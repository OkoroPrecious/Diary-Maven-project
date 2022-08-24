package com.precious.diary.services;

import com.precious.diary.dataTransferObjects.RegisterUserRequest;
import com.precious.diary.dataTransferObjects.UpdateUserRequest;
import com.precious.diary.dataTransferObjects.UserResponse;
import com.precious.diary.models.User;

import java.util.List;

public interface UserService {
    String createUser(RegisterUserRequest registerUserRequest);
    UserResponse readUser(String userId);
    String updateUser(UpdateUserRequest updateUserRequest);
    String deleteUser(String userId);

    List<User> findAllUsers();

    User getUserObj(String userId);
}
