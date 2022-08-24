package com.precious.diary.utils;

import com.precious.diary.dataTransferObjects.*;
import com.precious.diary.models.Diary;
import com.precious.diary.models.Entry;
import com.precious.diary.models.User;

public class Mapper {
    public static void mapRegisterUserRequestToUser(RegisterUserRequest registerUserRequest, User user) {
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setName(registerUserRequest.getName());
    }

    public static void mapUpdateUserRequestToUser(UpdateUserRequest updateUserRequest, User user) {
        if(updateUserRequest.getName() != null && !updateUserRequest.getName().equals("")  ){
            user.setName(updateUserRequest.getName());
        }
        if(updateUserRequest.getEmail() != null && !updateUserRequest.getEmail().equals("")  ){
            user.setEmail(updateUserRequest.getEmail());
        }
        if(updateUserRequest.getPassword() != null && !updateUserRequest.getPassword().equals("") ) {
            user.setPassword(updateUserRequest.getPassword());
        }
    }

    public static void mapRegisterEntryRequestToEntry(RegisterEntryRequest registerEntryRequest, Entry entry) {
        entry.setTitle(registerEntryRequest.getTitle());
        entry.setBody(registerEntryRequest.getBody());
    }

    public static void mapUpdateEntryRequestToEntry(UpdateEntryRequest updateEntryRequest, Entry entry){
        if(updateEntryRequest.getTitle() != null && !updateEntryRequest.getTitle().equals("")  ){
                entry.setTitle(updateEntryRequest.getTitle());
            }
        if(updateEntryRequest.getBody() != null && !updateEntryRequest.getBody().equals("")  ){
                entry.setBody(updateEntryRequest.getBody());
        }
    }

    public static void mapUpdateDiaryRequestToEntry(UpdateDiaryRequest updateDiaryRequest, Diary diary) {
        if(updateDiaryRequest.getDiaryName() != null && !updateDiaryRequest.getDiaryName().equals("")  ){
            diary.setDiaryName(updateDiaryRequest.getDiaryName());
        }
    }
}
