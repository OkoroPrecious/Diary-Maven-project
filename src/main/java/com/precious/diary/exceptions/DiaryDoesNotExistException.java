package com.precious.diary.exceptions;

public class DiaryDoesNotExistException extends RuntimeException{
    public DiaryDoesNotExistException(String message){
        super(message);
    }
}
