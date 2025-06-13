package com.inventory.gui;

import com.inventory.dao.ProductDAO;
import com.inventory.util.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private ProductManagementPanel productPanel;
    private CategoryManagementPanel categoryPanel;
    private DashboardPanel dashboardPanel;
    private ProductDAO productDAO;
    
    public MainFrame() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        centerWindow();
        
        // Test database connection on startup
        if (!DatabaseConnection.testConnection()) {
            JOptionPane.showMessageDialog(this,
                "Failed to connect to database!\n" +
                "Please check your MySQL connection settings in DatabaseConnection.java",
                "Database Connection Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void initializeComponents() {
        productDAO = new ProductDAO();
        
        // Set up main frame
        setTitle("Inventory Management System");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1200, 800);
        
        // Create tabbed pane with better styling
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        // Create panels
        dashboardPanel = new DashboardPanel();
        productPanel = new ProductManagementPanel();
        categoryPanel = new CategoryManagementPanel();
        
        // Add panels to tabbed pane with better spacing
        tabbedPane.addTab("   Dashboard   ", null, dashboardPanel, "View system overview and statistics");
        tabbedPane.addTab("   Products   ", null, productPanel, "Manage product inventory");
        tabbedPane.addTab("   Categories   ", null, categoryPanel, "Manage product categories");
        
        // Set tab colors for better visual appeal
        tabbedPane.setBackgroundAt(0, new Color(240, 248, 255)); // Light blue
        tabbedPane.setBackgroundAt(1, new Color(240, 255, 240)); // Light green  
        tabbedPane.setBackgroundAt(2, new Color(255, 248, 220)); // Light yellow
        
        // Set initial tab
        tabbedPane.setSelectedIndex(0);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Add header panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);
        
        // Add main content
        add(tabbedPane, BorderLayout.CENTER);
        
        // Add status bar
        JPanel statusPanel = createStatusPanel();
        add(statusPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(44, 62, 80)); // Darker professional blue
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(52, 152, 219)),
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));
        
        // Title with improved styling
        JLabel titleLabel = new JLabel("Inventory Management System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        
        // Quick stats
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        statsPanel.setOpaque(false);
        
        JLabel statsLabel = new JLabel("Loading...");
        statsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statsLabel.setForeground(new Color(236, 240, 241));
        
        // Update stats in background
        SwingWorker<String, Void> statsWorker = new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                try {
                    int productCount = productDAO.getProductCount();
                    BigDecimal totalValue = productDAO.getTotalInventoryValue();
                    return String.format("Products: %d | Total Value: $%.2f", productCount, totalValue);
                } catch (Exception e) {
                    return "Stats unavailable";
                }
            }
            
            @Override
            protected void done() {
                try {
                    statsLabel.setText(get());
                } catch (Exception e) {
                    statsLabel.setText("Stats unavailable");
                }
            }
        };
        statsWorker.execute();
        
        statsPanel.add(statsLabel);
        
        panel.add(titleLabel, BorderLayout.WEST);
        panel.add(statsPanel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        panel.setBackground(new Color(248, 249, 250));
        
        JLabel statusLabel = new JLabel("Ready");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JLabel connectionLabel = new JLabel();
        connectionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        // Check connection status
        if (DatabaseConnection.testConnection()) {
            connectionLabel.setText("Database Connected");
            connectionLabel.setForeground(new Color(39, 174, 96));
        } else {
            connectionLabel.setText("Database Disconnected");
            connectionLabel.setForeground(new Color(231, 76, 60));
        }
        
        panel.add(statusLabel, BorderLayout.WEST);
        panel.add(connectionLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private void setupEventHandlers() {
        // Window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
        
        // Tab change listener to refresh data
        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0: // Dashboard
                    dashboardPanel.refreshData();
                    break;
                case 1: // Products
                    productPanel.refreshData();
                    break;
                case 2: // Categories
                    categoryPanel.refreshData();
                    break;
            }
        });
    }
    
    private void centerWindow() {
        setLocationRelativeTo(null);
    }
    

    
    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit?",
            "Confirm Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (option == JOptionPane.YES_OPTION) {
            // Close database connection
            DatabaseConnection.closeConnection();
            System.exit(0);
        }
    }
    
    // Method to refresh all panels
    public void refreshAllPanels() {
        dashboardPanel.refreshData();
        productPanel.refreshData();
        categoryPanel.refreshData();
    }
    
    // Method to switch to specific tab
    public void switchToTab(int tabIndex) {
        if (tabIndex >= 0 && tabIndex < tabbedPane.getTabCount()) {
            tabbedPane.setSelectedIndex(tabIndex);
        }
    }
} 