package com.precious.diary.controllers;

import com.precious.diary.dataTransferObjects.RegisterEntryRequest;
import com.precious.diary.dataTransferObjects.RegisterUserRequest;
import com.precious.diary.dataTransferObjects.UpdateUserRequest;
import com.precious.diary.services.EntryService;
import com.precious.diary.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AppController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        log.info("entering controller");
        try {
            return new ResponseEntity<>(userService.createUser(registerUserRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(userService.readUser(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {

        return new ResponseEntity<>(userService.updateUser(updateUserRequest), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?>deleteUser(@PathVariable String userId) {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);

    }
    @GetMapping("/all-users")
    public ResponseEntity<?> findAllUsers(){
        return  new ResponseEntity<>(userService.findAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/user-obj/{userId}")
    public ResponseEntity<?> getUserObj(@PathVariable String userId){
        return  new ResponseEntity<>(userService.getUserObj(userId),HttpStatus.OK);
    }



}
