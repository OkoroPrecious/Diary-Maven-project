package com.precious.diary.serviceImplementations;

import com.precious.diary.dataTransferObjects.RegisterDiaryRequest;
import com.precious.diary.dataTransferObjects.UpdateDiaryRequest;
import com.precious.diary.exceptions.DiaryDoesNotExistException;
import com.precious.diary.exceptions.DiaryNotFoundException;
import com.precious.diary.models.Diary;
import com.precious.diary.repositories.DiaryRepository;
import com.precious.diary.services.DiaryService;
import com.precious.diary.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryRepository diaryRepository;

    public String createDiary(RegisterDiaryRequest registerDiaryRequest) {
        Diary diary = new Diary();
        String diaryName = registerDiaryRequest.getDiaryName();
        diary.setDiaryName(diaryName);
        diaryRepository.save(diary);
        return "Diary created successfully";
    }

    @Override
    public Diary readDiary(String diaryId) {
        var diary = diaryRepository.findById(diaryId);
        if (diary.isPresent()) {
            return diary.get();
        }
        throw new DiaryNotFoundException("Diary not found");
    }


    @Override
    public String updateDiary(UpdateDiaryRequest updateDiaryRequest) {
        var diary = diaryRepository.findById(updateDiaryRequest.getDiaryId());
        if (diary.isPresent()) {
            Mapper.mapUpdateDiaryRequestToEntry(updateDiaryRequest, diary.get());
            diaryRepository.save(diary.get());
        } else {
            throw new DiaryDoesNotExistException("Diary with id " + updateDiaryRequest.getDiaryId() + " does not exist");
        }
        return "Diary updated successfully";

    }

    @Override
    public String deleteDiary(String diaryId) {
        diaryRepository.deleteById(diaryId);
        return "Diary deleted successfully";
    }
}
