package com.example.internationchecklistbackend.repositories;

import com.example.internationchecklistbackend.entities.Checklist;
import com.example.internationchecklistbackend.entities.ChecklistSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    public Checklist findChecklistById(String id);
    public List<Checklist> findAll();
}
