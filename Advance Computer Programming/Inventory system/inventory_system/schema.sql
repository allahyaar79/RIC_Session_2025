-- Inventory Management System Database Schema

CREATE DATABASE IF NOT EXISTS inventory_system;
USE inventory_system;

-- Categories table
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Products table
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    quantity_in_stock INT DEFAULT 0,
    minimum_stock_level INT DEFAULT 10,
    supplier_name VARCHAR(150),
    supplier_contact VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- Stock transactions table for tracking inventory movements
CREATE TABLE stock_transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    transaction_type ENUM('IN', 'OUT') NOT NULL,
    quantity INT NOT NULL,
    reason VARCHAR(200),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

-- Insert sample categories
INSERT INTO categories (name, description) VALUES
('Electronics', 'Electronic devices and components'),
('Furniture', 'Office and home furniture'),
('Stationery', 'Office supplies and stationery items'),
('Clothing', 'Apparel and clothing items'),
('Books', 'Books and educational materials');

-- Insert sample products
INSERT INTO products (name, description, category_id, price, quantity_in_stock, minimum_stock_level, supplier_name, supplier_contact) VALUES
('Laptop Dell XPS 13', 'High-performance ultrabook', 1, 1299.99, 15, 5, 'Dell Inc.', 'dell@supplier.com'),
('Office Chair', 'Ergonomic office chair with lumbar support', 2, 299.99, 25, 10, 'Office Furniture Co.', 'contact@officefurniture.com'),
('Wireless Mouse', 'Bluetooth wireless mouse', 1, 29.99, 50, 20, 'Tech Supplies', 'tech@supplies.com'),
('Notebook A4', 'Ruled notebook 200 pages', 3, 4.99, 100, 50, 'Paper Works', 'info@paperworks.com'),
('Blue Jeans', 'Classic blue denim jeans', 4, 49.99, 30, 15, 'Fashion Hub', 'orders@fashionhub.com');

-- Create indexes for better performance
CREATE INDEX idx_products_category ON products(category_id);
CREATE INDEX idx_products_name ON products(name);
CREATE INDEX idx_stock_transactions_product ON stock_transactions(product_id);
CREATE INDEX idx_stock_transactions_date ON stock_transactions(transaction_date); 