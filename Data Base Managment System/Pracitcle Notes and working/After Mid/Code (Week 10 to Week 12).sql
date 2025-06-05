-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 06:38 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joins_functions_270525`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `credit_limit` decimal(10,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_name`, `email`, `phone`, `join_date`, `credit_limit`, `status`) VALUES
(201, 'ABC Corporation', 'contact@abccorp.com', '555-1001', '2018-01-15', 10000.00, 'Active'),
(202, 'XYZ Enterprises', 'sales@xyz.com', '555-1002', '2018-03-20', 7500.00, 'Active'),
(203, 'Global Tech', 'info@globaltech.com', '555-1003', '2018-05-10', 15000.00, 'Active'),
(204, 'Sunrise Solutions', 'contact@sunrise.com', '555-1004', '2018-07-05', 5000.00, 'Inactive'),
(205, 'Summit Industries', 'orders@summit.com', '555-1005', '2018-09-12', 12000.00, 'Active'),
(206, 'Horizon LLC', 'support@horizon.com', '555-1006', '2018-11-18', 8000.00, 'Active'),
(207, 'Pioneer Systems', 'sales@pioneer.com', '555-1007', '2019-01-22', 6000.00, 'Inactive'),
(208, 'Apex Services', 'info@apex.com', '555-1008', '2019-03-30', 9000.00, 'Active'),
(209, 'Vertex Technologies', 'contact@vertex.com', '555-1009', '2019-05-15', 11000.00, 'Active'),
(210, 'Nova Corporation', 'sales@nova.com', '555-1010', '2019-07-10', 7000.00, 'Active'),
(211, 'Elite Business Solutions', 'info@elite.com', '555-1011', '2019-09-05', 13000.00, 'Active'),
(212, 'Prime Consulting', 'contact@prime.com', '555-1012', '2019-11-20', 8500.00, 'Inactive'),
(213, 'Infinity Group', 'sales@infinity.com', '555-1013', '2020-01-15', 9500.00, 'Active'),
(214, 'Orion Partners', 'info@orion.com', '555-1014', '2020-03-10', 6500.00, 'Active'),
(215, 'Phoenix Enterprises', 'contact@phoenix.com', '555-1015', '2020-05-25', 14000.00, 'Active'),
(216, 'Titan Industries', 'sales@titan.com', '555-1016', '2020-07-18', 5500.00, 'Inactive'),
(217, 'Zenith Corporation', 'info@zenith.com', '555-1017', '2020-09-12', 12500.00, 'Active'),
(218, 'Pinnacle Solutions', 'contact@pinnacle.com', '555-1018', '2020-11-05', 7500.00, 'Active'),
(219, 'Vanguard Systems', 'sales@vanguard.com', '555-1019', '2021-01-20', 10500.00, 'Active'),
(220, 'Odyssey Technologies', 'info@odyssey.com', '555-1020', '2021-03-15', 8500.00, 'Inactive');

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `budget` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`department_id`, `department_name`, `location`, `budget`) VALUES
(10, 'Administration', 'HQ Floor 1', 100000.00),
(20, 'Marketing', 'Building A', 80000.00),
(30, 'IT', 'Building B', 120000.00),
(40, 'Sales', 'Building C', 150000.00),
(50, 'HR', 'HQ Floor 2', 90000.00),
(60, 'Finance', 'HQ Floor 3', 110000.00),
(70, 'Operations', 'Building D', 95000.00),
(80, 'Customer Support', 'Building E', 75000.00),
(90, 'Research & Development', 'Building F', 130000.00),
(100, 'Legal', 'HQ Floor 4', 85000.00),
(110, 'Procurement', 'Building G', 70000.00),
(120, 'Quality Assurance', 'Building H', 88000.00),
(130, 'Engineering', 'Building I', 140000.00),
(140, 'Design', 'Building J', 92000.00),
(150, 'Logistics', 'Building K', 78000.00),
(160, 'Training', 'Building L', 65000.00),
(170, 'Security', 'HQ Basement', 60000.00),
(180, 'Facilities', 'Building M', 72000.00),
(190, 'Public Relations', 'Building N', 82000.00),
(200, 'Business Development', 'Building O', 95000.00);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `hire_date` date NOT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `commission_pct` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `first_name`, `last_name`, `email`, `hire_date`, `salary`, `department_id`, `manager_id`, `commission_pct`) VALUES
(1001, 'John', 'Smith', 'john.smith@company.com', '2015-06-15', 75000.00, 10, NULL, NULL),
(1002, 'Sarah', 'Johnson', 'sarah.johnson@company.com', '2016-08-21', 68000.00, 20, 1001, 0.05),
(1003, 'Michael', 'Williams', 'michael.williams@company.com', '2017-03-10', 72000.00, 30, 1001, NULL),
(1004, 'Emily', 'Brown', 'emily.brown@company.com', '2018-11-05', 65000.00, 40, 1002, 0.07),
(1005, 'David', 'Jones', 'david.jones@company.com', '2019-06-30', 58000.00, 50, 1001, NULL),
(1006, 'Jennifer', 'Garcia', 'jennifer.garcia@company.com', '2020-01-15', 62000.00, 20, 1002, 0.04),
(1007, 'Robert', 'Miller', 'robert.miller@company.com', '2016-07-22', 78000.00, 30, 1003, NULL),
(1008, 'Jessica', 'Davis', 'jessica.davis@company.com', '2017-09-18', 71000.00, 60, 1001, NULL),
(1009, 'Thomas', 'Rodriguez', 'thomas.rodriguez@company.com', '2018-04-30', 67000.00, 40, 1004, 0.06),
(1010, 'Lisa', 'Martinez', 'lisa.martinez@company.com', '2019-12-10', 59000.00, 50, 1005, NULL),
(1011, 'Daniel', 'Hernandez', 'daniel.hernandez@company.com', '2020-02-28', 56000.00, 30, 1007, NULL),
(1012, 'Michelle', 'Lopez', 'michelle.lopez@company.com', '2017-11-15', 64000.00, 70, 1001, 0.03),
(1013, 'Charles', 'Gonzalez', 'charles.gonzalez@company.com', '2018-08-05', 69000.00, 80, 1001, NULL),
(1014, 'Amanda', 'Wilson', 'amanda.wilson@company.com', '2019-05-20', 63000.00, 40, 1004, 0.05),
(1015, 'Christopher', 'Anderson', 'christopher.anderson@company.com', '2020-03-10', 61000.00, 90, 1001, NULL),
(1016, 'Matthew', 'Thomas', 'matthew.thomas@company.com', '2016-06-12', 74000.00, 60, 1008, NULL),
(1017, 'Ashley', 'Taylor', 'ashley.taylor@company.com', '2017-09-25', 67000.00, 70, 1012, 0.04),
(1018, 'Joshua', 'Moore', 'joshua.moore@company.com', '2018-07-18', 71000.00, 100, 1001, NULL),
(1019, 'Stephanie', 'Jackson', 'stephanie.jackson@company.com', '2019-04-05', 65000.00, 40, 1004, 0.06),
(1020, 'Andrew', 'Martin', 'andrew.martin@company.com', '2020-10-30', 60000.00, 30, 1007, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `event_log`
--

CREATE TABLE `event_log` (
  `event_id` int(11) NOT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `start_datetime` datetime DEFAULT NULL,
  `end_datetime` datetime DEFAULT NULL,
  `duration_minutes` int(11) DEFAULT NULL,
  `time_recorded` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event_log`
--

INSERT INTO `event_log` (`event_id`, `event_name`, `start_datetime`, `end_datetime`, `duration_minutes`, `time_recorded`) VALUES
(1, 'System Startup', '2023-01-01 08:00:00', '2023-01-01 08:02:30', 2, '08:02:30'),
(2, 'Database Backup', '2023-01-01 23:00:00', '2023-01-01 23:45:15', 45, '23:45:15'),
(3, 'User Login', '2023-01-02 09:15:22', '2023-01-02 09:15:45', 0, '09:15:45'),
(4, 'Data Export', '2023-01-02 14:30:00', '2023-01-02 14:42:10', 12, '14:42:10'),
(5, 'System Maintenance', '2023-01-03 02:00:00', '2023-01-03 03:30:00', 90, '03:30:00'),
(6, 'Error Detected', '2023-01-03 11:05:33', '2023-01-03 11:05:33', 0, '11:05:33'),
(7, 'Batch Processing', '2023-01-04 00:15:00', '2023-01-04 01:05:20', 50, '01:05:20'),
(8, 'API Call', '2023-01-04 10:30:45', '2023-01-04 10:30:52', 0, '10:30:52'),
(9, 'Security Scan', '2023-01-05 04:00:00', '2023-01-05 04:25:10', 25, '04:25:10'),
(10, 'Cache Clear', '2023-01-05 15:20:00', '2023-01-05 15:21:05', 1, '15:21:05'),
(11, 'Report Generation', '2023-01-06 08:45:00', '2023-01-06 08:50:30', 5, '08:50:30'),
(12, 'Database Optimization', '2023-01-07 03:00:00', '2023-01-07 03:45:00', 45, '03:45:00'),
(13, 'User Session', '2023-01-08 13:15:10', '2023-01-08 14:30:45', 75, '14:30:45'),
(14, 'System Update', '2023-01-09 18:00:00', '2023-01-09 18:30:15', 30, '18:30:15'),
(15, 'Data Import', '2023-01-10 09:30:00', '2023-01-10 09:55:20', 25, '09:55:20'),
(16, 'Nightly Process', '2023-01-11 22:00:00', '2023-01-11 23:10:00', 70, '23:10:00'),
(17, 'Alert Triggered', '2023-01-12 16:45:12', '2023-01-12 16:45:12', 0, '16:45:12'),
(18, 'Backup Verification', '2023-01-13 01:00:00', '2023-01-13 01:15:30', 15, '01:15:30'),
(19, 'System Reboot', '2023-01-14 07:00:00', '2023-01-14 07:02:15', 2, '07:02:15'),
(20, 'Data Sync', '2023-01-15 12:00:00', '2023-01-15 12:10:45', 10, '12:10:45');

-- --------------------------------------------------------

--
-- Table structure for table `job_grades`
--

CREATE TABLE `job_grades` (
  `grade_level` varchar(2) NOT NULL,
  `lowest_sal` decimal(10,2) DEFAULT NULL,
  `highest_sal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job_grades`
--

INSERT INTO `job_grades` (`grade_level`, `lowest_sal`, `highest_sal`) VALUES
('A1', 30000.00, 39999.99),
('A2', 40000.00, 49999.99),
('A3', 50000.00, 59999.99),
('B1', 60000.00, 69999.99),
('B2', 70000.00, 79999.99),
('B3', 80000.00, 89999.99),
('C1', 90000.00, 99999.99),
('C2', 100000.00, 109999.99),
('C3', 110000.00, 119999.99),
('D1', 120000.00, 129999.99),
('D2', 130000.00, 139999.99),
('D3', 140000.00, 149999.99),
('E1', 150000.00, 159999.99),
('E2', 160000.00, 169999.99),
('E3', 170000.00, 179999.99),
('F1', 180000.00, 189999.99),
('F2', 190000.00, 199999.99),
('F3', 200000.00, 209999.99),
('G1', 210000.00, 219999.99),
('G2', 220000.00, 229999.99);

-- --------------------------------------------------------

--
-- Table structure for table `mixed_formats`
--

CREATE TABLE `mixed_formats` (
  `id` int(11) NOT NULL,
  `string_number` varchar(20) DEFAULT NULL,
  `date_string` varchar(30) DEFAULT NULL,
  `number_as_text` varchar(15) DEFAULT NULL,
  `boolean_value` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mixed_formats`
--

INSERT INTO `mixed_formats` (`id`, `string_number`, `date_string`, `number_as_text`, `boolean_value`) VALUES
(1, '123.45', '2023-01-15', '1001', 1),
(2, '67.89', '15/01/2023', '2002', 0),
(3, '0.005', 'January 15, 2023', '3003', 1),
(4, '1000000', '20230115', '4004', 0),
(5, '-45.67', '15-Jan-2023', '5005', 1),
(6, '3.14159', '01/15/23', '6006', 0),
(7, '2.99792458E8', '2023-15-01', '7007', 1),
(8, '0', '15.01.2023', '8008', 0),
(9, '999.999', 'Jan 15 2023', '9009', 1),
(10, '1.234e-5', '2023-01-15 12:00:00', '1010', 0),
(11, '42', '15th January 2023', '1111', 1),
(12, '0.0001', '2023-W03-1', '1212', 0),
(13, '-999.99', 'Sunday, January 15, 2023', '1313', 1),
(14, '100,000', '2023/01/15', '1414', 0),
(15, '1.0E6', '15-1-2023', '1515', 1),
(16, '0.5', '2023.01.15', '1616', 0),
(17, '123456789', '01-15-2023', '1717', 1),
(18, '3.33333', '2023-01', '1818', 0),
(19, '1.618', '15-Jan', '1919', 1),
(20, '9.99', 'Q1 2023', '2020', 0);

-- --------------------------------------------------------

--
-- Table structure for table `numeric_data`
--

CREATE TABLE `numeric_data` (
  `id` int(11) NOT NULL,
  `value1` decimal(10,4) DEFAULT NULL,
  `value2` decimal(10,4) DEFAULT NULL,
  `int_value` int(11) DEFAULT NULL,
  `negative_value` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `numeric_data`
--

INSERT INTO `numeric_data` (`id`, `value1`, `value2`, `int_value`, `negative_value`) VALUES
(1, 123.4567, 789.0123, 42, -15.75),
(2, 3.1415, 2.7182, 100, -0.99),
(3, 10000.0001, 9999.9999, 32767, -100.00),
(4, 0.0001, 0.9999, 0, -0.01),
(5, 999999.9999, 0.0001, -32768, -999.99),
(6, 1.2345, 5.4321, 12345, -3.14),
(7, 0.0000, 1.0000, 1, -1.00),
(8, 9876.5432, 2345.6789, 9876, -876.54),
(9, 0.3333, 0.6666, 33, -0.33),
(10, 2.9979, 9.8066, 299792, -9.81),
(11, 1.6180, 3.1415, 1618, -1.62),
(12, 100.0000, 0.0001, 100, -100.00),
(13, 0.5000, 0.2500, 50, -0.50),
(14, 1234.5678, 8765.4321, 1234, -567.89),
(15, 9.9999, 0.0001, 9999, -0.01),
(16, 0.0000, 0.0000, 0, 0.00),
(17, 65535.0000, 1.0000, 65535, -1.00),
(18, 1.0001, 0.9999, 1, -0.01),
(19, 100000.0000, 0.0001, 100000, -0.10),
(20, 0.1234, 0.4321, 1234, -4.32);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `expiry_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `description`, `category`, `price`, `cost`, `created_date`, `expiry_date`) VALUES
(101, 'Laptop Elite', '15-inch business laptop', 'Electronics', 1299.99, 800.00, '2022-01-15 00:00:00', NULL),
(102, 'Wireless Mouse Pro', 'Ergonomic wireless mouse', 'Accessories', 49.99, 15.00, '2022-02-20 00:00:00', NULL),
(103, 'Mechanical Keyboard RGB', 'RGB mechanical keyboard', 'Accessories', 89.99, 35.00, '2022-03-10 00:00:00', NULL),
(104, 'Monitor 27\" 4K', '4K UHD monitor', 'Electronics', 399.99, 250.00, '2022-04-05 00:00:00', NULL),
(105, 'Noise-Cancelling Headphones', 'Bluetooth headphones', 'Audio', 199.99, 90.00, '2022-05-12 00:00:00', NULL),
(106, 'Ergonomic Office Chair', 'Premium office chair', 'Furniture', 249.99, 150.00, '2022-06-18 00:00:00', NULL),
(107, 'LED Desk Lamp', 'Adjustable desk lamp', 'Furniture', 39.99, 12.00, '2022-07-22 00:00:00', NULL),
(108, 'Premium Notebook', 'Hardcover notebook', 'Stationery', 12.99, 3.00, '2022-08-30 00:00:00', '2025-12-31'),
(109, 'Executive Pen Set', 'Ballpoint pen set', 'Stationery', 24.99, 8.00, '2022-09-15 00:00:00', NULL),
(110, 'Ceramic Coffee Mug', 'Company branded mug', 'Kitchen', 9.99, 2.50, '2022-10-10 00:00:00', NULL),
(111, 'Heavy-Duty Stapler', 'Professional stapler', 'Office Supplies', 14.99, 4.50, '2022-11-05 00:00:00', NULL),
(112, 'Paper Shredder', 'Cross-cut shredder', 'Office Equipment', 79.99, 40.00, '2022-12-12 00:00:00', NULL),
(113, 'Portable SSD 1TB', 'External SSD drive', 'Electronics', 149.99, 75.00, '2023-01-20 00:00:00', NULL),
(114, 'HD Webcam', 'Webcam with microphone', 'Electronics', 59.99, 25.00, '2023-02-15 00:00:00', NULL),
(115, 'USB-C Hub', '4-port USB hub', 'Accessories', 19.99, 6.00, '2023-03-10 00:00:00', NULL),
(116, 'Desk Organizer', 'Wooden desk organizer', 'Furniture', 29.99, 10.00, '2023-04-05 00:00:00', NULL),
(117, 'Wireless Charger', 'Qi wireless charger', 'Accessories', 34.99, 12.00, '2023-05-18 00:00:00', NULL),
(118, 'Laptop Stand', 'Adjustable stand', 'Accessories', 49.99, 18.00, '2023-06-22 00:00:00', NULL),
(119, 'Whiteboard 4x6', 'Large whiteboard', 'Office Equipment', 89.99, 45.00, '2023-07-30 00:00:00', NULL),
(120, 'Desk Calendar 2024', 'Yearly calendar', 'Stationery', 14.99, 4.00, '2023-08-15 00:00:00', '2024-12-31');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `sale_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `sale_date` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `discount` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sale_id`, `product_id`, `sale_date`, `quantity`, `unit_price`, `customer_id`, `region`, `discount`) VALUES
(10001, 101, '2023-01-05 10:15:00', 1, 1299.99, 201, 'North', 0.00),
(10002, 102, '2023-01-06 11:30:00', 2, 49.99, 202, 'South', 0.05),
(10003, 103, '2023-01-07 14:45:00', 1, 89.99, 203, 'East', 0.10),
(10004, 104, '2023-01-08 09:20:00', 1, 399.99, 204, 'West', 0.00),
(10005, 105, '2023-01-09 13:10:00', 1, 199.99, 205, 'North', 0.15),
(10006, 106, '2023-01-10 15:30:00', 2, 249.99, 206, 'South', 0.00),
(10007, 107, '2023-01-11 16:45:00', 3, 39.99, 207, 'East', 0.20),
(10008, 108, '2023-01-12 10:00:00', 5, 12.99, 208, 'West', 0.00),
(10009, 109, '2023-01-13 11:15:00', 1, 24.99, 209, 'North', 0.10),
(10010, 110, '2023-01-14 14:30:00', 4, 9.99, 210, 'South', 0.00),
(10011, 111, '2023-01-15 09:45:00', 2, 14.99, 211, 'East', 0.05),
(10012, 112, '2023-01-16 12:00:00', 1, 79.99, 212, 'West', 0.00),
(10013, 113, '2023-01-17 13:20:00', 1, 149.99, 213, 'North', 0.10),
(10014, 114, '2023-01-18 15:40:00', 2, 59.99, 214, 'South', 0.00),
(10015, 115, '2023-01-19 16:55:00', 3, 19.99, 215, 'East', 0.15),
(10016, 116, '2023-01-20 10:10:00', 1, 29.99, 216, 'West', 0.00),
(10017, 117, '2023-01-21 11:25:00', 2, 34.99, 217, 'North', 0.20),
(10018, 118, '2023-01-22 14:40:00', 1, 49.99, 218, 'South', 0.00),
(10019, 119, '2023-01-23 09:55:00', 1, 89.99, 219, 'East', 0.10),
(10020, 120, '2023-01-24 12:10:00', 3, 14.99, 220, 'West', 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `text_samples`
--

CREATE TABLE `text_samples` (
  `id` int(11) NOT NULL,
  `sample_text` varchar(255) DEFAULT NULL,
  `mixed_case` varchar(100) DEFAULT NULL,
  `padded_string` varchar(50) DEFAULT NULL,
  `long_text` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `text_samples`
--

INSERT INTO `text_samples` (`id`, `sample_text`, `mixed_case`, `padded_string`, `long_text`) VALUES
(1, 'Hello World', 'HeLlO WoRlD', '   padded   ', 'This is a sample long text that might be used for testing purposes.'),
(2, 'Database', 'DaTaBaSe', '  leading', 'Another example of longer text content that exceeds typical field lengths.'),
(3, 'SQL Query', 'SqL QuErY', 'trailing  ', 'Text processing functions need to handle various string lengths and content.'),
(4, 'MySQL', 'MySqL', '  both  ', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),
(5, 'PostgreSQL', 'PoStGrEsQl', 'no_padding', 'String manipulation is a common requirement in database operations.'),
(6, 'Oracle', 'OrAcLe', '   space   ', 'Testing different text functions requires diverse sample data.'),
(7, 'SQL Server', 'SqL SeRvEr', 'tab	', 'Regular expressions and pattern matching need good test cases.'),
(8, 'MongoDB', 'MoNgOdB', 'new\nline', 'Text data can include special characters and formatting.'),
(9, 'Redis', 'ReDiS', 'mixed  	', 'Performance testing requires substantial text data volumes.'),
(10, 'Elasticsearch', 'ElAsTiCsEaRcH', '  	\n  ', 'Full-text search capabilities depend on quality test data.'),
(11, 'Cassandra', 'CaSsAnDrA', 'normal', 'Internationalization testing needs Unicode text samples.'),
(12, 'Neo4j', 'NeO4J', 'short', 'Graph databases also handle text properties and indexes.'),
(13, 'SQLite', 'SqLiTe', 'medium length', 'Embedded databases need text processing capabilities too.'),
(14, 'MariaDB', 'MaRiAdB', 'very long padded string   ', 'Compatibility testing requires similar but not identical text.'),
(15, 'DB2', 'Db2', 'minimal', 'Enterprise databases handle complex text operations.'),
(16, 'Snowflake', 'SnOwFlAkE', '  cloud  ', 'Cloud data warehouses process text columns efficiently.'),
(17, 'BigQuery', 'BiGqUeRy', 'analyze', 'Analytical databases need text processing for BI tools.'),
(18, 'Redshift', 'ReDsHiFt', '   AWS   ', 'Data warehousing solutions include text functions.'),
(19, 'DynamoDB', 'DyNaMoDb', 'NoSQL', 'Key-value stores also handle text data types.'),
(20, 'CosmosDB', 'CoSmOsDb', 'multi-model', 'Microsoft\'s multi-model database handles text extensively.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `department_id` (`department_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `event_log`
--
ALTER TABLE `event_log`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `job_grades`
--
ALTER TABLE `job_grades`
  ADD PRIMARY KEY (`grade_level`);

--
-- Indexes for table `mixed_formats`
--
ALTER TABLE `mixed_formats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `numeric_data`
--
ALTER TABLE `numeric_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`sale_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `text_samples`
--
ALTER TABLE `text_samples`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`),
  ADD CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`employee_id`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
