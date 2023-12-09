package com.example.internationchecklistbackend.repositories;

import com.example.internationchecklistbackend.entities.ChecklistSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistSectionRepository extends JpaRepository<ChecklistSection, Long> {
}
