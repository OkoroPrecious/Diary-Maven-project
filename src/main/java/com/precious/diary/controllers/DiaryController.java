package com.precious.diary.controllers;

import com.precious.diary.dataTransferObjects.RegisterDiaryRequest;
import com.precious.diary.dataTransferObjects.RegisterEntryRequest;
import com.precious.diary.dataTransferObjects.UpdateDiaryRequest;
import com.precious.diary.dataTransferObjects.UpdateUserRequest;
import com.precious.diary.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PostMapping("/diary")
    public ResponseEntity<?> registerEntry(@RequestBody RegisterDiaryRequest registerDiaryRequest){
       try{
           return new ResponseEntity<>(diaryService.createDiary(registerDiaryRequest), HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/diary/{diaryId}")
    public ResponseEntity<?> getDiary(@PathVariable String diaryId) {
        try {
            return new ResponseEntity<>(diaryService.readDiary(diaryId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/diary")
    public ResponseEntity<?> updateDiary(@RequestBody UpdateDiaryRequest updateDiaryRequest) {

        return new ResponseEntity<>(diaryService.updateDiary(updateDiaryRequest), HttpStatus.OK);
    }

    @DeleteMapping("/diary/{diaryId}")
    public ResponseEntity<?>deleteDiary(@PathVariable String diaryId) {
        return new ResponseEntity<>(diaryService.deleteDiary(diaryId), HttpStatus.OK);
    }

}
