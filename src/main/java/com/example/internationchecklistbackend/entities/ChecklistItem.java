package com.example.internationchecklistbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class ChecklistItem {
    @Id
    public String id;
    public String text1;
    public String text2;

    public int displayType;

    @ColumnDefault("1")
    public int flag;
}
