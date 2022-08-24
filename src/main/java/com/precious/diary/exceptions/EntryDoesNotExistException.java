package com.precious.diary.exceptions;

public class EntryDoesNotExistException extends RuntimeException{
    public EntryDoesNotExistException(String message){
        super(message);
    }
}
