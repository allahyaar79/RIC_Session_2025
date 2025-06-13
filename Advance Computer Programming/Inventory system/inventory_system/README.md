# Inventory Management System

A complete CRUD (Create, Read, Update, Delete) GUI application built with Core Java Swing and MySQL for managing inventory operations.

## Features

- **Dashboard**: System overview with statistics and low stock alerts
- **Product Management**: Complete CRUD operations for products
- **Category Management**: Manage product categories
- **Search & Filter**: Advanced search and filtering capabilities
- **Low Stock Alerts**: Automatic alerts for products below minimum stock levels
- **Professional GUI**: Modern Swing-based user interface
- **Database Integration**: Full MySQL database integration

## Technology Stack

- **Frontend**: Java Swing
- **Backend**: Core Java
- **Database**: MySQL
- **Build Tool**: Maven
- **JDBC Driver**: MySQL Connector/J

## Prerequisites

Before running the application, ensure you have:

1. **Java Development Kit (JDK) 11 or higher**
2. **MySQL Server 8.0 or higher**
3. **Maven 3.6 or higher** (optional, for building)

## Setup Instructions

### 1. Database Setup

1. Start your MySQL server
2. Create the database and tables by running the SQL script:
   ```bash
   mysql -u root -p < schema.sql
   ```
3. Update database connection settings in `src/com/inventory/util/DatabaseConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/inventory_system";
   private static final String USERNAME = "your_username";
   private static final String PASSWORD = "your_password";
   ```

### 2. Dependencies

The application requires the MySQL JDBC driver. You can either:

**Option A: Using Maven**
```bash
mvn clean compile
```

**Option B: Manual Setup**
Download `mysql-connector-java-8.0.33.jar` and add it to your classpath.

### 3. Running the Application

**Using Maven:**
```bash
mvn exec:java -Dexec.mainClass="com.inventory.InventorySystemApp"
```

**Using Java directly:**
```bash
javac -cp ".:mysql-connector-java-8.0.33.jar" src/com/inventory/**/*.java
java -cp ".:mysql-connector-java-8.0.33.jar:src" com.inventory.InventorySystemApp
```

**Building executable JAR:**
```bash
mvn clean package
java -jar target/inventory-management-system-1.0.0-jar-with-dependencies.jar
```

## Project Structure

```
inventory_system/
│
├── src/
│   └── com/
│       └── inventory/
│           ├── dao/                 # Data Access Objects
│           │   ├── CategoryDAO.java
│           │   └── ProductDAO.java
│           ├── gui/                 # GUI Components
│           │   ├── CategoryDialog.java
│           │   ├── CategoryManagementPanel.java
│           │   ├── DashboardPanel.java
│           │   ├── MainFrame.java
│           │   ├── ProductDialog.java
│           │   └── ProductManagementPanel.java
│           ├── model/               # Data Models
│           │   ├── Category.java
│           │   └── Product.java
│           ├── util/                # Utilities
│           │   └── DatabaseConnection.java
│           └── InventorySystemApp.java  # Main Application
│
├── schema.sql                       # Database Schema
├── pom.xml                         # Maven Configuration
└── README.md                       # This file
```

## Database Schema

### Tables

1. **categories**
   - `id` (Primary Key)
   - `name` (Unique)
   - `description`
   - `created_at`
   - `updated_at`

2. **products**
   - `id` (Primary Key)
   - `name`
   - `description`
   - `category_id` (Foreign Key)
   - `price`
   - `quantity_in_stock`
   - `minimum_stock_level`
   - `supplier_name`
   - `supplier_contact`
   - `created_at`
   - `updated_at`

3. **stock_transactions**
   - `id` (Primary Key)
   - `product_id` (Foreign Key)
   - `transaction_type` (IN/OUT)
   - `quantity`
   - `reason`
   - `transaction_date`

## Application Features

### Dashboard
- Total products count
- Total categories count
- Total inventory value
- Low stock items alert
- Quick overview of system status

### Product Management
- Add new products with validation
- Edit existing products
- Delete products with confirmation
- Search products by name
- Filter products by category
- View all product details in table format
- Automatic low stock detection

### Category Management
- Add new categories
- Edit existing categories
- Delete categories (with product reassignment)
- Search categories by name
- View category details

### User Interface Features
- Modern, professional design
- Tabbed interface for easy navigation
- Form validation with error messages
- Confirmation dialogs for delete operations
- Status bar with connection status
- Responsive table layouts
- Double-click to edit functionality

## Sample Data

The schema includes sample data:
- 5 product categories (Electronics, Furniture, Stationery, Clothing, Books)
- 5 sample products with different categories and stock levels

## Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Verify MySQL server is running
   - Check database credentials in `DatabaseConnection.java`
   - Ensure the database `inventory_system` exists

2. **ClassNotFoundException: com.mysql.cj.jdbc.Driver**
   - Download and add MySQL JDBC driver to classpath
   - Or use Maven to manage dependencies

3. **GUI Not Displaying Properly**
   - Ensure you're using Java 11 or higher
   - Check if your system supports Swing applications

### Error Messages

- **"Failed to connect to database"**: Check MySQL connection settings
- **"Product name is required"**: Fill in all required fields in forms
- **"Category not found"**: Refresh the data or check database consistency

## Contributing

To contribute to this project:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under the MIT License.

## Support

For issues and questions:
- Check the troubleshooting section
- Review the database schema
- Verify all dependencies are properly installed

---

**Note**: This is an educational project demonstrating CRUD operations with Java Swing and MySQL. For production use, consider adding additional features like user authentication, data backup, and enhanced security measures. 