package com.precious.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document("Diary")
@Data

public class  Diary {
    private String diaryName;
    @Id
    private String diaryId;
    @DBRef
    private List<Entry> entries = new ArrayList<>();
}
