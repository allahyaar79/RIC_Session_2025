package com.inventory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/inventory_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // Change this to your MySQL password
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection connection = null;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {}
    
    /**
     * Get database connection instance (creates new connection each time)
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connection established successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database!");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Close database connection
     */
    public static void closeConnection() {
        // Individual connections are closed in try-with-resources blocks
        // This method is kept for compatibility
        System.out.println("Database connections are managed automatically.");
    }
    
    /**
     * Test database connection
     */
    public static boolean testConnection() {
        try {
            Connection testConn = getConnection();
            if (testConn != null && !testConn.isClosed()) {
                testConn.close(); // Close test connection
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
} 