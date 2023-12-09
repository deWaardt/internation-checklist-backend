package com.example.internationchecklistbackend.services;

import com.example.internationchecklistbackend.repositories.ChecklistSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistSectionService {
    private final ChecklistSectionRepository checklistSectionRepository;

    @Autowired
    public ChecklistSectionService(ChecklistSectionRepository checklistSectionRepository) {
        this.checklistSectionRepository = checklistSectionRepository;
    }


}
