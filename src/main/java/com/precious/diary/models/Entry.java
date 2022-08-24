package com.precious.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Entry")
@Data

public class Entry {
    private String title;
    private String body;
    @Id
    private String entryId;
}
