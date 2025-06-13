package com.inventory.model;

import java.sql.Timestamp;

public class Category {
    private int id;
    private String name;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    // Default constructor
    public Category() {}
    
    // Constructor without ID (for new categories)
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // Constructor with ID (for display purposes - like "All Categories")
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    // Constructor with all fields
    public Category(int id, String name, String description, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return name; // For ComboBox display
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Category category = (Category) obj;
        return id == category.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
} 