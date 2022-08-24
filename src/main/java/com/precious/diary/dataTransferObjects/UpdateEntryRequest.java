package com.precious.diary.dataTransferObjects;

import lombok.Data;

@Data

public class UpdateEntryRequest {
    private String title;
    private String body;
    private String entryId;
}
