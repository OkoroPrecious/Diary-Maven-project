package com.precious.diary.exceptions;

public class DiaryNotFoundException extends  RuntimeException{
    public DiaryNotFoundException(String message){
        super(message);
    }
}
