package com.inventory;

import com.inventory.gui.MainFrame;
import com.inventory.util.DatabaseConnection;

import javax.swing.*;

public class InventorySystemApp {
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Failed to set system look and feel: " + e.getMessage());
        }
        
        // Run the application on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Starting Inventory Management System...");
                    System.out.println("Testing database connection...");
                    
                    // Test database connection before starting
                    if (!DatabaseConnection.testConnection()) {
                        System.out.println("Database connection failed!");
                        int option = JOptionPane.showConfirmDialog(
                            null,
                            "Failed to connect to database!\n" +
                            "Please make sure MySQL is running and the database exists.\n" +
                            "Do you want to continue anyway?",
                            "Database Connection Error",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                        );
                        
                        if (option != JOptionPane.YES_OPTION) {
                            System.out.println("User chose to exit due to database error.");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Database connection successful!");
                    }
                    
                    System.out.println("Creating main application window...");
                    // Create and show main frame
                    MainFrame mainFrame = new MainFrame();
                    System.out.println("Setting window visible...");
                    mainFrame.setVisible(true);
                    System.out.println("Application window should be visible now!");
                    
                    // Show welcome message
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(
                            mainFrame,
                            "Welcome to Inventory Management System!\n\n" +
                            "Features:\n" +
                            "* Dashboard with system overview\n" +
                            "* Complete product management (CRUD)\n" +
                            "* Category management\n" +
                            "* Low stock alerts\n" +
                            "* Search and filter capabilities\n\n" +
                            "Before using the system:\n" +
                            "1. Make sure MySQL is running\n" +
                            "2. Run the schema.sql file to create the database\n" +
                            "3. Update database credentials in DatabaseConnection.java",
                            "Welcome",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    });
                    
                } catch (Exception e) {
                    System.err.println("ERROR: Failed to start application!");
                    System.err.println("Exception: " + e.getClass().getName());
                    System.err.println("Message: " + e.getMessage());
                    e.printStackTrace();
                    
                    JOptionPane.showMessageDialog(
                        null,
                        "Failed to start application: " + e.getMessage(),
                        "Startup Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    System.exit(1);
                }
            }
        });
    }
} 