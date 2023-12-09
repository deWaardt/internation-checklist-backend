package com.example.internationchecklistbackend.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class ChecklistSection {
    @Id
    public String id;
    public String name;

    @OneToMany (cascade = {CascadeType.ALL})
    public List<ChecklistItem> items;
}
