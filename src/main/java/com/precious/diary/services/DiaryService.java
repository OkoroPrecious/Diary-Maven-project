package com.precious.diary.services;

import com.precious.diary.dataTransferObjects.RegisterDiaryRequest;
import com.precious.diary.dataTransferObjects.UpdateDiaryRequest;
import com.precious.diary.dataTransferObjects.UpdateUserRequest;
import com.precious.diary.models.Diary;

public interface DiaryService {
     String createDiary(RegisterDiaryRequest registerDiaryRequest);
    Diary readDiary(String diaryId);
     String updateDiary(UpdateDiaryRequest updateDiaryRequest);
     String deleteDiary(String diaryId);


}
