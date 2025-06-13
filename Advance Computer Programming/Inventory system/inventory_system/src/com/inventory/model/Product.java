package com.inventory.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private String description;
    private int categoryId;
    private String categoryName; // For display purposes
    private BigDecimal price;
    private int quantityInStock;
    private int minimumStockLevel;
    private String supplierName;
    private String supplierContact;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    // Default constructor
    public Product() {}
    
    // Constructor without ID (for new products)
    public Product(String name, String description, int categoryId, BigDecimal price, 
                   int quantityInStock, int minimumStockLevel, String supplierName, String supplierContact) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.minimumStockLevel = minimumStockLevel;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
    }
    
    // Constructor with all fields
    public Product(int id, String name, String description, int categoryId, String categoryName, 
                   BigDecimal price, int quantityInStock, int minimumStockLevel, 
                   String supplierName, String supplierContact, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.minimumStockLevel = minimumStockLevel;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
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
    
    public int getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }
    
    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }
    
    public String getSupplierName() {
        return supplierName;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public String getSupplierContact() {
        return supplierContact;
    }
    
    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
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
    
    // Helper method to check if stock is low
    public boolean isLowStock() {
        return quantityInStock <= minimumStockLevel;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
} 