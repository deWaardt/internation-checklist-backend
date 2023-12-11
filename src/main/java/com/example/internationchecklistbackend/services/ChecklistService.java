package com.example.internationchecklistbackend.services;

import com.example.internationchecklistbackend.entities.Checklist;
import com.example.internationchecklistbackend.repositories.ChecklistItemRepository;
import com.example.internationchecklistbackend.repositories.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {
    private final ChecklistRepository checklistRepository;

    @Autowired
    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    public Checklist getChecklistById(String id) {
        return checklistRepository.findChecklistById(id);
    }

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public void saveChecklist(Checklist checklist) {
        checklistRepository.save(checklist);
    }

    public void deleteChecklist(Checklist checklist) {
        checklistRepository.delete(checklist);
    }
}
