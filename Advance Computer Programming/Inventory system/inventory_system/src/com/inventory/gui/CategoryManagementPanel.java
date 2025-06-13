package com.inventory.gui;

import com.inventory.dao.CategoryDAO;
import com.inventory.model.Category;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CategoryManagementPanel extends JPanel {
    private CategoryDAO categoryDAO;
    private JTable categoryTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton addButton, editButton, deleteButton, refreshButton;
    
    public CategoryManagementPanel() {
        categoryDAO = new CategoryDAO();
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        loadTableData();
    }
    
    private void initializeComponents() {
        // Create table
        String[] columnNames = {"ID", "Name", "Description", "Created At", "Updated At"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        categoryTable = new JTable(tableModel);
        categoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categoryTable.setRowHeight(25);
        
        // Set column widths
        categoryTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        categoryTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        categoryTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        categoryTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        categoryTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        // Create search field
        searchField = new JTextField(20);
        searchField.setToolTipText("Search categories by name...");
        
        // Create buttons
        addButton = new JButton("Add Category");
        editButton = new JButton("Edit Category");
        deleteButton = new JButton("Delete Category");
        refreshButton = new JButton("Refresh");
        
        // Style buttons
        styleButton(addButton, new Color(39, 174, 96));
        styleButton(editButton, new Color(52, 152, 219));
        styleButton(deleteButton, new Color(231, 76, 60));
        styleButton(refreshButton, new Color(149, 165, 166));
        
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    
    private void styleButton(JButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setPreferredSize(new Dimension(130, 35));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Center panel with table
        JScrollPane scrollPane = new JScrollPane(categoryTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Categories"));
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void setupEventHandlers() {
        // Search functionality
        searchField.addActionListener(e -> filterTable());
        
        // Table selection
        categoryTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean hasSelection = categoryTable.getSelectedRow() != -1;
                editButton.setEnabled(hasSelection);
                deleteButton.setEnabled(hasSelection);
            }
        });
        
        // Button actions
        addButton.addActionListener(e -> showAddCategoryDialog());
        editButton.addActionListener(e -> showEditCategoryDialog());
        deleteButton.addActionListener(e -> deleteSelectedCategory());
        refreshButton.addActionListener(e -> refreshData());
        
        // Double-click to edit
        categoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2 && categoryTable.getSelectedRow() != -1) {
                    showEditCategoryDialog();
                }
            }
        });
    }
    
    private void loadTableData() {
        SwingWorker<List<Category>, Void> worker = new SwingWorker<List<Category>, Void>() {
            @Override
            protected List<Category> doInBackground() throws Exception {
                return categoryDAO.readAll();
            }
            
            @Override
            protected void done() {
                try {
                    List<Category> categories = get();
                    updateTableModel(categories);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(CategoryManagementPanel.this,
                        "Error loading categories: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
    
    private void updateTableModel(List<Category> categories) {
        tableModel.setRowCount(0);
        
        for (Category category : categories) {
            Object[] row = {
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt()
            };
            tableModel.addRow(row);
        }
    }
    
    private void filterTable() {
        String searchText = searchField.getText().trim().toLowerCase();
        
        if (searchText.isEmpty()) {
            loadTableData();
        } else {
            SwingWorker<List<Category>, Void> worker = new SwingWorker<List<Category>, Void>() {
                @Override
                protected List<Category> doInBackground() throws Exception {
                    return categoryDAO.searchByName(searchText);
                }
                
                @Override
                protected void done() {
                    try {
                        List<Category> categories = get();
                        updateTableModel(categories);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(CategoryManagementPanel.this,
                            "Error searching categories: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            };
            worker.execute();
        }
    }
    
    private void showAddCategoryDialog() {
        CategoryDialog dialog = new CategoryDialog(
            (JFrame) SwingUtilities.getWindowAncestor(this),
            "Add Category",
            null
        );
        
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Category category = dialog.getCategory();
            if (categoryDAO.create(category)) {
                JOptionPane.showMessageDialog(this,
                    "Category added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to add category!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void showEditCategoryDialog() {
        int selectedRow = categoryTable.getSelectedRow();
        if (selectedRow == -1) return;
        
        int categoryId = (Integer) tableModel.getValueAt(selectedRow, 0);
        Category category = categoryDAO.read(categoryId);
        
        if (category == null) {
            JOptionPane.showMessageDialog(this,
                "Category not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CategoryDialog dialog = new CategoryDialog(
            (JFrame) SwingUtilities.getWindowAncestor(this),
            "Edit Category",
            category
        );
        
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Category updatedCategory = dialog.getCategory();
            updatedCategory.setId(categoryId);
            
            if (categoryDAO.update(updatedCategory)) {
                JOptionPane.showMessageDialog(this,
                    "Category updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to update category!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void deleteSelectedCategory() {
        int selectedRow = categoryTable.getSelectedRow();
        if (selectedRow == -1) return;
        
        int categoryId = (Integer) tableModel.getValueAt(selectedRow, 0);
        String categoryName = (String) tableModel.getValueAt(selectedRow, 1);
        
        int option = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete the category '" + categoryName + "'?\n" +
            "This will set all products in this category to have no category.",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (option == JOptionPane.YES_OPTION) {
            if (categoryDAO.delete(categoryId)) {
                JOptionPane.showMessageDialog(this,
                    "Category deleted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to delete category!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void refreshData() {
        loadTableData();
        searchField.setText("");
    }
} 