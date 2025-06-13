package com.inventory.gui;

import com.inventory.model.Category;
import com.inventory.model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class ProductDialog extends JDialog {
    private Product product;
    private List<Category> categories;
    private boolean confirmed = false;
    
    // Form components
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JComboBox<Category> categoryCombo;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField minStockField;
    private JTextField supplierNameField;
    private JTextField supplierContactField;
    
    private JButton saveButton;
    private JButton cancelButton;
    
    public ProductDialog(JFrame parent, String title, Product product, List<Category> categories) {
        super(parent, title, true);
        this.product = product;
        this.categories = categories;
        
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        populateFields();
        
        setSize(500, 600);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void initializeComponents() {
        // Create form fields
        nameField = new JTextField(20);
        descriptionArea = new JTextArea(3, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        
        categoryCombo = new JComboBox<>();
        for (Category category : categories) {
            categoryCombo.addItem(category);
        }
        
        priceField = new JTextField(10);
        quantityField = new JTextField(10);
        minStockField = new JTextField(10);
        supplierNameField = new JTextField(20);
        supplierContactField = new JTextField(20);
        
        // Create buttons
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        // Style buttons
        saveButton.setBackground(new Color(39, 174, 96));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        
        cancelButton.setBackground(new Color(149, 165, 166));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Main form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Product Name
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Product Name: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nameField, gbc);
        
        // Description
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH;
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        descScrollPane.setPreferredSize(new Dimension(250, 80));
        formPanel.add(descScrollPane, gbc);
        
        // Category
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(new JLabel("Category: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(categoryCombo, gbc);
        
        // Price
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Price: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(priceField, gbc);
        
        // Quantity in Stock
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Quantity in Stock: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(quantityField, gbc);
        
        // Minimum Stock Level
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Minimum Stock Level: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(minStockField, gbc);
        
        // Supplier Name
        gbc.gridx = 0; gbc.gridy = 6; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Supplier Name:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(supplierNameField, gbc);
        
        // Supplier Contact
        gbc.gridx = 0; gbc.gridy = 7; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Supplier Contact:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(supplierContactField, gbc);
        
        // Required fields note
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel noteLabel = new JLabel("* Required fields");
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        noteLabel.setForeground(Color.GRAY);
        formPanel.add(noteLabel, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void setupEventHandlers() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        // Enter key to save
        getRootPane().setDefaultButton(saveButton);
    }
    
    private void populateFields() {
        if (product != null) {
            nameField.setText(product.getName());
            descriptionArea.setText(product.getDescription());
            
            // Select category
            for (int i = 0; i < categoryCombo.getItemCount(); i++) {
                Category category = categoryCombo.getItemAt(i);
                if (category.getId() == product.getCategoryId()) {
                    categoryCombo.setSelectedIndex(i);
                    break;
                }
            }
            
            priceField.setText(product.getPrice().toString());
            quantityField.setText(String.valueOf(product.getQuantityInStock()));
            minStockField.setText(String.valueOf(product.getMinimumStockLevel()));
            supplierNameField.setText(product.getSupplierName());
            supplierContactField.setText(product.getSupplierContact());
        } else {
            // Set defaults for new product
            quantityField.setText("0");
            minStockField.setText("10");
        }
    }
    
    private void saveProduct() {
        // Validate input
        if (!validateInput()) {
            return;
        }
        
        try {
            // Create or update product object
            if (product == null) {
                product = new Product();
            }
            
            product.setName(nameField.getText().trim());
            product.setDescription(descriptionArea.getText().trim());
            
            Category selectedCategory = (Category) categoryCombo.getSelectedItem();
            product.setCategoryId(selectedCategory.getId());
            
            product.setPrice(new BigDecimal(priceField.getText().trim()));
            product.setQuantityInStock(Integer.parseInt(quantityField.getText().trim()));
            product.setMinimumStockLevel(Integer.parseInt(minStockField.getText().trim()));
            product.setSupplierName(supplierNameField.getText().trim());
            product.setSupplierContact(supplierContactField.getText().trim());
            
            confirmed = true;
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numeric values for price, quantity, and minimum stock level.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error saving product: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        // Check required fields
        if (nameField.getText().trim().isEmpty()) {
            showValidationError("Product name is required.");
            nameField.requestFocus();
            return false;
        }
        
        if (categoryCombo.getSelectedItem() == null) {
            showValidationError("Please select a category.");
            categoryCombo.requestFocus();
            return false;
        }
        
        if (priceField.getText().trim().isEmpty()) {
            showValidationError("Price is required.");
            priceField.requestFocus();
            return false;
        }
        
        if (quantityField.getText().trim().isEmpty()) {
            showValidationError("Quantity in stock is required.");
            quantityField.requestFocus();
            return false;
        }
        
        if (minStockField.getText().trim().isEmpty()) {
            showValidationError("Minimum stock level is required.");
            minStockField.requestFocus();
            return false;
        }
        
        // Validate numeric fields
        try {
            BigDecimal price = new BigDecimal(priceField.getText().trim());
            if (price.compareTo(BigDecimal.ZERO) < 0) {
                showValidationError("Price cannot be negative.");
                priceField.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            showValidationError("Please enter a valid price.");
            priceField.requestFocus();
            return false;
        }
        
        try {
            int quantity = Integer.parseInt(quantityField.getText().trim());
            if (quantity < 0) {
                showValidationError("Quantity cannot be negative.");
                quantityField.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            showValidationError("Please enter a valid quantity.");
            quantityField.requestFocus();
            return false;
        }
        
        try {
            int minStock = Integer.parseInt(minStockField.getText().trim());
            if (minStock < 0) {
                showValidationError("Minimum stock level cannot be negative.");
                minStockField.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            showValidationError("Please enter a valid minimum stock level.");
            minStockField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void showValidationError(String message) {
        JOptionPane.showMessageDialog(this,
            message,
            "Validation Error",
            JOptionPane.WARNING_MESSAGE);
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public Product getProduct() {
        return product;
    }
} 