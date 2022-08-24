package com.precious.diary.serviceImplementations;

import com.precious.diary.dataTransferObjects.EntryResponse;
import com.precious.diary.dataTransferObjects.RegisterEntryRequest;
import com.precious.diary.dataTransferObjects.UpdateEntryRequest;
import com.precious.diary.exceptions.EntryDoesNotExistException;
import com.precious.diary.models.Entry;
import com.precious.diary.repositories.EntryRepository;
import com.precious.diary.services.EntryService;
import com.precious.diary.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j


public class EntryServiceImpl implements EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public String createEntry(RegisterEntryRequest registerEntryRequest) {
         Entry entry = new Entry();
//         String title = registerEntryRequest.getTitle();
//         String body = registerEntryRequest.getBody();
//         entry.setTitle(title);
//         entry.setBody(body);

         Mapper.mapRegisterEntryRequestToEntry(registerEntryRequest, entry );
         entryRepository.save(entry);
         return "Entry created successfully";
    }

    @Override
    public EntryResponse readEntry(String entryId) {
        var entry = entryRepository.findById(entryId);
        if(entry.isPresent()){
            EntryResponse entryResponse = new EntryResponse();
            entryResponse.setTitle(entry.get().getTitle());
            entryResponse.setBody(entry.get().getBody());
            return entryResponse;
        }
        throw new EntryDoesNotExistException("entry with id "+entryId+" does not exist");
    }

    @Override
    public String updateEntry(UpdateEntryRequest updateEntryRequest) {
        var entry = entryRepository.findById(updateEntryRequest.getEntryId());
        if(entry.isPresent()){
            /*if(updateEntryRequest.getTitle() != null && !updateEntryRequest.getTitle().equals("")  ){
                entry.setTitle(updateEntryRequest.getTitle());
            }
            if(updateEntryRequest.getBody() != null && !updateEntryRequest.getBody().equals("")  ){
                entry.setBody(updateEntryRequest.getBody());
            }
             */

            Mapper.mapUpdateEntryRequestToEntry(updateEntryRequest, entry.get());
            entryRepository.save(entry.get());
        }else{
            throw new EntryDoesNotExistException("Entry with id "+updateEntryRequest.getEntryId()+" does not exist");
        }
        return "Entry updated successfully";

    }

    @Override
    public String deleteEntry(String entryId) {
        entryRepository.deleteById(entryId);
        return "Entry deleted successfully";

    }
}
