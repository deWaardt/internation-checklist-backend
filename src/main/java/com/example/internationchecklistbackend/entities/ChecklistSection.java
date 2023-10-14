package com.example.internationchecklistbackend.entities;

import java.io.Serializable;

public class ChecklistSection implements Serializable {
    public String id;
    public String name;
    public ChecklistItem[] items;
}
