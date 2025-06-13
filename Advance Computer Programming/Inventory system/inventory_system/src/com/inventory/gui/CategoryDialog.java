package com.inventory.gui;

import com.inventory.model.Category;

import javax.swing.*;
import java.awt.*;

public class CategoryDialog extends JDialog {
    private Category category;
    private boolean confirmed = false;
    
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JButton saveButton;
    private JButton cancelButton;
    
    public CategoryDialog(JFrame parent, String title, Category category) {
        super(parent, title, true);
        this.category = category;
        
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        populateFields();
        
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void initializeComponents() {
        nameField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        saveButton.setBackground(new Color(39, 174, 96));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        
        cancelButton.setBackground(new Color(149, 165, 166));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Category Name: *"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        formPanel.add(scrollPane, gbc);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void setupEventHandlers() {
        saveButton.addActionListener(e -> saveCategory());
        cancelButton.addActionListener(e -> dispose());
        getRootPane().setDefaultButton(saveButton);
    }
    
    private void populateFields() {
        if (category != null) {
            nameField.setText(category.getName());
            descriptionArea.setText(category.getDescription());
        }
    }
    
    private void saveCategory() {
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Category name is required.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            nameField.requestFocus();
            return;
        }
        
        if (category == null) {
            category = new Category();
        }
        
        category.setName(nameField.getText().trim());
        category.setDescription(descriptionArea.getText().trim());
        
        confirmed = true;
        dispose();
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public Category getCategory() {
        return category;
    }
} 