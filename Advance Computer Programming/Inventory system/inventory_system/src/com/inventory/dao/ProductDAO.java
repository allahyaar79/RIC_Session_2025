package com.inventory.dao;

import com.inventory.model.Product;
import com.inventory.util.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    
    // Create a new product
    public boolean create(Product product) {
        String sql = "INSERT INTO products (name, description, category_id, price, quantity_in_stock, " +
                     "minimum_stock_level, supplier_name, supplier_contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getCategoryId());
            stmt.setBigDecimal(4, product.getPrice());
            stmt.setInt(5, product.getQuantityInStock());
            stmt.setInt(6, product.getMinimumStockLevel());
            stmt.setString(7, product.getSupplierName());
            stmt.setString(8, product.getSupplierContact());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Get the generated ID
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        product.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error creating product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    // Read a product by ID
    public Product read(int id) {
        String sql = "SELECT p.*, c.name AS category_name FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id WHERE p.id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProduct(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error reading product: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    // Read all products
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.name AS category_name FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id ORDER BY p.name";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error reading all products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
    
    // Update a product
    public boolean update(Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, category_id = ?, price = ?, " +
                     "quantity_in_stock = ?, minimum_stock_level = ?, supplier_name = ?, " +
                     "supplier_contact = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getCategoryId());
            stmt.setBigDecimal(4, product.getPrice());
            stmt.setInt(5, product.getQuantityInStock());
            stmt.setInt(6, product.getMinimumStockLevel());
            stmt.setString(7, product.getSupplierName());
            stmt.setString(8, product.getSupplierContact());
            stmt.setInt(9, product.getId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    // Delete a product
    public boolean delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    // Search products by name
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.name AS category_name FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id " +
                     "WHERE p.name LIKE ? ORDER BY p.name";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + name + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapResultSetToProduct(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error searching products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
    
    // Get products by category
    public List<Product> getByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.name AS category_name FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id " +
                     "WHERE p.category_id = ? ORDER BY p.name";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, categoryId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapResultSetToProduct(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting products by category: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
    
    // Get low stock products
    public List<Product> getLowStockProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.*, c.name AS category_name FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id " +
                     "WHERE p.quantity_in_stock <= p.minimum_stock_level ORDER BY p.name";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error getting low stock products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }
    
    // Update stock quantity
    public boolean updateStock(int productId, int newQuantity) {
        String sql = "UPDATE products SET quantity_in_stock = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, newQuantity);
            stmt.setInt(2, productId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error updating stock: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    // Get product count
    public int getProductCount() {
        String sql = "SELECT COUNT(*) FROM products";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error getting product count: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    
    // Get total inventory value
    public BigDecimal getTotalInventoryValue() {
        String sql = "SELECT SUM(price * quantity_in_stock) FROM products";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                BigDecimal total = rs.getBigDecimal(1);
                return total != null ? total : BigDecimal.ZERO;
            }
        } catch (SQLException e) {
            System.err.println("Error getting total inventory value: " + e.getMessage());
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }
    
    // Helper method to map ResultSet to Product object
    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setCategoryId(rs.getInt("category_id"));
        product.setCategoryName(rs.getString("category_name"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setQuantityInStock(rs.getInt("quantity_in_stock"));
        product.setMinimumStockLevel(rs.getInt("minimum_stock_level"));
        product.setSupplierName(rs.getString("supplier_name"));
        product.setSupplierContact(rs.getString("supplier_contact"));
        product.setCreatedAt(rs.getTimestamp("created_at"));
        product.setUpdatedAt(rs.getTimestamp("updated_at"));
        return product;
    }
} 