package com.precious.diary.serviceImplementations;

import com.precious.diary.dataTransferObjects.RegisterUserRequest;
import com.precious.diary.dataTransferObjects.UpdateUserRequest;
import com.precious.diary.dataTransferObjects.UserResponse;
import com.precious.diary.exceptions.EmailAlreadyExistException;
import com.precious.diary.exceptions.UserDoesNotExistException;
import com.precious.diary.models.User;
import com.precious.diary.repositories.UserRepository;
import com.precious.diary.services.UserService;
import com.precious.diary.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(RegisterUserRequest registerUserRequest) {
        log.info("creating user  with details -> {}",registerUserRequest);

        var users = userRepository.findAll();
        for (var user: users){
            if (user.getEmail().equalsIgnoreCase(registerUserRequest.getEmail())){
                throw new EmailAlreadyExistException("email "+registerUserRequest.getEmail()+" already exist");
            }
        }

//        String email = registerUserRequest.getEmail();
//        String name = registerUserRequest.getName();
//        String password = registerUserRequest.getPassword();

        User user = new User();
        Mapper.mapRegisterUserRequestToUser(registerUserRequest, user);

        userRepository.save(user);
        return "registered successfully";

    }

    @Override
    public UserResponse readUser(String userId) {
        var user =userRepository.findById(userId);
        if(user.isPresent()){
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.get().getEmail());
            userResponse.setName(user.get().getName());
            return userResponse;
        }
        throw new UserDoesNotExistException("user with id "+userId+" does not exist");
    }

    @Override
    public String updateUser(UpdateUserRequest updateUserRequest) {
        var user = userRepository.findById(updateUserRequest.getUserId());
        if(user.isPresent()){
            Mapper.mapUpdateUserRequestToUser(updateUserRequest,user.get());
            userRepository.save(user.get());
        }else {
            throw new UserDoesNotExistException("user with id "+updateUserRequest.getUserId()+" does not exist");
        }
        return "updated successfully";

    }

    @Override
    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "deleted successfully";
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserObj(String userId) {
        return userRepository.findById(userId).get();
    }
}
