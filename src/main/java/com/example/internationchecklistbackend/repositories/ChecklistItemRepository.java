package com.example.internationchecklistbackend.repositories;

import com.example.internationchecklistbackend.entities.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, Long>{
}
