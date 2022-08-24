package com.precious.diary.services;

import com.precious.diary.dataTransferObjects.EntryResponse;
import com.precious.diary.dataTransferObjects.RegisterEntryRequest;
import com.precious.diary.dataTransferObjects.UpdateEntryRequest;

public interface   EntryService {
    String createEntry(RegisterEntryRequest registerEntryRequest);

    EntryResponse readEntry(String entryId);
    String updateEntry(UpdateEntryRequest updateEntryRequest);
    String deleteEntry(String entryId);
}
