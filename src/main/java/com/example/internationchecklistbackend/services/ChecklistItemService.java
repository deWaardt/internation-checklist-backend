package com.example.internationchecklistbackend.services;

import com.example.internationchecklistbackend.repositories.ChecklistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistItemService {
    private final ChecklistItemRepository checklistItemRepository;

    @Autowired
    public ChecklistItemService(ChecklistItemRepository checklistItemRepository) {
        this.checklistItemRepository = checklistItemRepository;
    }

}
