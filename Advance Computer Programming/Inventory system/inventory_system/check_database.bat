@echo off
echo Database Setup Checker
echo =====================
echo.

echo Step 1: Checking if MySQL is running...
netstat -an | findstr :3306 >nul
if errorlevel 1 (
    echo ❌ MySQL is not running on port 3306
    echo Please start MySQL server first.
    echo.
    pause
    exit /b 1
) else (
    echo ✅ MySQL is running on port 3306
)

echo.
echo Step 2: Testing database connection...
echo Note: You'll need to enter your MySQL password

mysql -u root -p -e "USE inventory_system; SHOW TABLES;"

if errorlevel 1 (
    echo.
    echo ❌ Database connection failed or database doesn't exist
    echo.
    echo To create the database, run:
    echo mysql -u root -p ^< schema.sql
    echo.
) else (
    echo.
    echo ✅ Database 'inventory_system' exists and is accessible!
    echo Your application should work now.
)

echo.
pause 