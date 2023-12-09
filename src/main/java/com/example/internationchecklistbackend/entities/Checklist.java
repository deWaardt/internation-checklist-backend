package com.example.internationchecklistbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Checklist {
    @Id
    public String id;


    public String image;
    public String aircraft;


    @OneToMany(cascade = {CascadeType.ALL})
    public List<ChecklistSection> sections;
}
