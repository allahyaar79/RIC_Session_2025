package com.inventory.gui;

import com.inventory.dao.CategoryDAO;
import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class DashboardPanel extends JPanel {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    
    private JLabel totalProductsLabel;
    private JLabel totalCategoriesLabel;
    private JLabel totalValueLabel;
    private JLabel lowStockCountLabel;
    private JTable lowStockTable;
    private DefaultTableModel lowStockTableModel;
    
    public DashboardPanel() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
        
        initializeComponents();
        setupLayout();
        refreshData();
    }
    
    private void initializeComponents() {
        // Create statistic labels
        totalProductsLabel = createStatLabel("0");
        totalCategoriesLabel = createStatLabel("0");
        totalValueLabel = createStatLabel("$0.00");
        lowStockCountLabel = createStatLabel("0");
        
        // Create low stock table
        String[] columnNames = {"Product Name", "Current Stock", "Min Stock", "Category"};
        lowStockTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        lowStockTable = new JTable(lowStockTableModel);
        lowStockTable.setRowHeight(25);
        lowStockTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        lowStockTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        lowStockTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        lowStockTable.getColumnModel().getColumn(3).setPreferredWidth(150);
    }
    
    private JLabel createStatLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 28));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Top panel with statistics
        JPanel statsPanel = createStatsPanel();
        
        // Bottom panel with low stock table
        JPanel lowStockPanel = createLowStockPanel();
        
        add(statsPanel, BorderLayout.NORTH);
        add(lowStockPanel, BorderLayout.CENTER);
    }
    
    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4, 25, 20));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 2), 
                "System Overview", 0, 0, new Font("Segoe UI", Font.BOLD, 16), new Color(52, 73, 94)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        panel.setPreferredSize(new Dimension(0, 180));
        panel.setBackground(Color.WHITE);
        
        // Create stat cards
        panel.add(createStatCard("Total Products", totalProductsLabel, new Color(52, 152, 219)));
        panel.add(createStatCard("Total Categories", totalCategoriesLabel, new Color(155, 89, 182)));
        panel.add(createStatCard("Total Inventory Value", totalValueLabel, new Color(39, 174, 96)));
        panel.add(createStatCard("Low Stock Items", lowStockCountLabel, new Color(231, 76, 60)));
        
        return panel;
    }
    
    private JPanel createStatCard(String title, JLabel valueLabel, Color backgroundColor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(backgroundColor);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(backgroundColor.darker(), 1),
            BorderFactory.createEmptyBorder(20, 15, 20, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        valueLabel.setForeground(Color.WHITE);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createLowStockPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Low Stock Alert"));
        
        // Add refresh button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton refreshButton = new JButton("Refresh Dashboard");
        refreshButton.setBackground(new Color(52, 152, 219));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.addActionListener(e -> refreshData());
        buttonPanel.add(refreshButton);
        
        JScrollPane scrollPane = new JScrollPane(lowStockTable);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    public void refreshData() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            private int productCount;
            private int categoryCount;
            private BigDecimal totalValue;
            private List<Product> lowStockProducts;
            
            @Override
            protected Void doInBackground() throws Exception {
                productCount = productDAO.getProductCount();
                categoryCount = categoryDAO.readAll().size();
                totalValue = productDAO.getTotalInventoryValue();
                lowStockProducts = productDAO.getLowStockProducts();
                return null;
            }
            
            @Override
            protected void done() {
                try {
                    updateStats(productCount, categoryCount, totalValue, lowStockProducts);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(DashboardPanel.this,
                        "Error refreshing dashboard: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
    
    private void updateStats(int productCount, int categoryCount, BigDecimal totalValue, List<Product> lowStockProducts) {
        totalProductsLabel.setText(String.valueOf(productCount));
        totalCategoriesLabel.setText(String.valueOf(categoryCount));
        totalValueLabel.setText(String.format("$%.2f", totalValue));
        lowStockCountLabel.setText(String.valueOf(lowStockProducts.size()));
        
        // Update low stock table
        lowStockTableModel.setRowCount(0);
        for (Product product : lowStockProducts) {
            Object[] row = {
                product.getName(),
                product.getQuantityInStock(),
                product.getMinimumStockLevel(),
                product.getCategoryName() != null ? product.getCategoryName() : "No Category"
            };
            lowStockTableModel.addRow(row);
        }
        
        // Show warning if there are low stock items
        if (!lowStockProducts.isEmpty()) {
            lowStockCountLabel.setForeground(Color.WHITE);
        }
    }
} 