package com.precious.diary.dataTransferObjects;

import lombok.Data;

@Data
public class RegisterEntryRequest {
    private String title;
    private String body;
}
