package com.inventory.gui;

import com.inventory.dao.CategoryDAO;
import com.inventory.dao.ProductDAO;
import com.inventory.model.Category;
import com.inventory.model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class ProductManagementPanel extends JPanel {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JComboBox<Category> categoryFilterCombo;
    private JButton addButton, editButton, deleteButton, refreshButton;
    private TableRowSorter<DefaultTableModel> sorter;
    
    public ProductManagementPanel() {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        loadTableData();
    }
    
    private void initializeComponents() {
        // Create table
        String[] columnNames = {"ID", "Name", "Description", "Category", "Price", "Stock", "Min Stock", "Supplier", "Contact"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        
        productTable = new JTable(tableModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setRowHeight(25);
        productTable.getTableHeader().setReorderingAllowed(false);
        
        // Set column widths
        productTable.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        productTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
        productTable.getColumnModel().getColumn(2).setPreferredWidth(200); // Description
        productTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Category
        productTable.getColumnModel().getColumn(4).setPreferredWidth(80);  // Price
        productTable.getColumnModel().getColumn(5).setPreferredWidth(60);  // Stock
        productTable.getColumnModel().getColumn(6).setPreferredWidth(80);  // Min Stock
        productTable.getColumnModel().getColumn(7).setPreferredWidth(120); // Supplier
        productTable.getColumnModel().getColumn(8).setPreferredWidth(120); // Contact
        
        // Add sorting
        sorter = new TableRowSorter<>(tableModel);
        productTable.setRowSorter(sorter);
        
        // Create search field
        searchField = new JTextField(20);
        searchField.setToolTipText("Search products by name...");
        
        // Create category filter
        categoryFilterCombo = new JComboBox<>();
        categoryFilterCombo.addItem(new Category(0, "All Categories", "Show all categories"));
        loadCategories();
        
        // Create buttons
        addButton = new JButton("Add Product");
        editButton = new JButton("Edit Product");
        deleteButton = new JButton("Delete Product");
        refreshButton = new JButton("Refresh");
        
        // Style buttons
        styleButton(addButton, new Color(39, 174, 96));
        styleButton(editButton, new Color(52, 152, 219));
        styleButton(deleteButton, new Color(231, 76, 60));
        styleButton(refreshButton, new Color(149, 165, 166));
        
        // Initially disable edit/delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    
    private void styleButton(JButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setPreferredSize(new Dimension(120, 35));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel with search and filter
        JPanel topPanel = new JPanel(new BorderLayout());
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(new JLabel("Category:"));
        searchPanel.add(categoryFilterCombo);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Center panel with table
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Products"));
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void setupEventHandlers() {
        // Search functionality
        searchField.addActionListener(e -> filterTable());
        
        // Category filter
        categoryFilterCombo.addActionListener(e -> filterTable());
        
        // Table selection
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean hasSelection = productTable.getSelectedRow() != -1;
                editButton.setEnabled(hasSelection);
                deleteButton.setEnabled(hasSelection);
            }
        });
        
        // Button actions
        addButton.addActionListener(e -> showAddProductDialog());
        editButton.addActionListener(e -> showEditProductDialog());
        deleteButton.addActionListener(e -> deleteSelectedProduct());
        refreshButton.addActionListener(e -> refreshData());
        
        // Double-click to edit
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2 && productTable.getSelectedRow() != -1) {
                    showEditProductDialog();
                }
            }
        });
    }
    
    private void loadCategories() {
        categoryFilterCombo.removeAllItems();
        categoryFilterCombo.addItem(new Category(0, "All Categories", "Show all categories"));
        
        List<Category> categories = categoryDAO.readAll();
        for (Category category : categories) {
            categoryFilterCombo.addItem(category);
        }
    }
    
    private void loadTableData() {
        SwingWorker<List<Product>, Void> worker = new SwingWorker<List<Product>, Void>() {
            @Override
            protected List<Product> doInBackground() throws Exception {
                return productDAO.readAll();
            }
            
            @Override
            protected void done() {
                try {
                    List<Product> products = get();
                    updateTableModel(products);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(ProductManagementPanel.this,
                        "Error loading products: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
    
    private void updateTableModel(List<Product> products) {
        tableModel.setRowCount(0);
        
        for (Product product : products) {
            Object[] row = {
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategoryName(),
                String.format("$%.2f", product.getPrice()),
                product.getQuantityInStock(),
                product.getMinimumStockLevel(),
                product.getSupplierName(),
                product.getSupplierContact()
            };
            tableModel.addRow(row);
            
            // Highlight low stock items
            if (product.isLowStock()) {
                int rowIndex = tableModel.getRowCount() - 1;
                // You can add custom rendering here for low stock items
            }
        }
    }
    
    private void filterTable() {
        String searchText = searchField.getText().trim();
        Category selectedCategory = (Category) categoryFilterCombo.getSelectedItem();
        
        if (searchText.isEmpty() && (selectedCategory == null || selectedCategory.getId() == 0)) {
            sorter.setRowFilter(null);
        } else {
            RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
                @Override
                public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
                    // Check search text (product name)
                    boolean matchesSearch = searchText.isEmpty() || 
                        entry.getStringValue(1).toLowerCase().contains(searchText.toLowerCase());
                    
                    // Check category filter
                    boolean matchesCategory = selectedCategory == null || selectedCategory.getId() == 0 ||
                        entry.getStringValue(3).equals(selectedCategory.getName());
                    
                    return matchesSearch && matchesCategory;
                }
            };
            sorter.setRowFilter(filter);
        }
    }
    
    private void showAddProductDialog() {
        ProductDialog dialog = new ProductDialog(
            (JFrame) SwingUtilities.getWindowAncestor(this),
            "Add Product",
            null,
            categoryDAO.readAll()
        );
        
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Product product = dialog.getProduct();
            if (productDAO.create(product)) {
                JOptionPane.showMessageDialog(this,
                    "Product added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to add product!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void showEditProductDialog() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) return;
        
        // Convert view row to model row
        int modelRow = productTable.convertRowIndexToModel(selectedRow);
        int productId = (Integer) tableModel.getValueAt(modelRow, 0);
        
        Product product = productDAO.read(productId);
        if (product == null) {
            JOptionPane.showMessageDialog(this,
                "Product not found!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ProductDialog dialog = new ProductDialog(
            (JFrame) SwingUtilities.getWindowAncestor(this),
            "Edit Product",
            product,
            categoryDAO.readAll()
        );
        
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Product updatedProduct = dialog.getProduct();
            updatedProduct.setId(productId);
            
            if (productDAO.update(updatedProduct)) {
                JOptionPane.showMessageDialog(this,
                    "Product updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to update product!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void deleteSelectedProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) return;
        
        // Convert view row to model row
        int modelRow = productTable.convertRowIndexToModel(selectedRow);
        int productId = (Integer) tableModel.getValueAt(modelRow, 0);
        String productName = (String) tableModel.getValueAt(modelRow, 1);
        
        int option = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete the product '" + productName + "'?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (option == JOptionPane.YES_OPTION) {
            if (productDAO.delete(productId)) {
                JOptionPane.showMessageDialog(this,
                    "Product deleted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                refreshData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Failed to delete product!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void refreshData() {
        loadCategories();
        loadTableData();
        searchField.setText("");
        categoryFilterCombo.setSelectedIndex(0);
    }
}