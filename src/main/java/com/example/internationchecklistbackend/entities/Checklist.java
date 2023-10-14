package com.example.internationchecklistbackend.entities;

import java.io.Serializable;

public class Checklist implements Serializable {
    public String id;
    public String aircraft;
    public ChecklistSection[] sections;
}
