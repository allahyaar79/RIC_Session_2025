@echo off
echo Inventory Management System - Compile and Run
echo ============================================
echo.

REM Set classpath
set CLASSPATH=src;mysql-connector-j-9.3.0/mysql-connector-j-9.3.0.jar

echo Step 1: Compiling utility classes...
javac -cp "%CLASSPATH%" src/com/inventory/util/DatabaseConnection.java
if errorlevel 1 goto error

echo Step 2: Compiling model classes...
javac -cp "%CLASSPATH%" src/com/inventory/model/Category.java
javac -cp "%CLASSPATH%" src/com/inventory/model/Product.java
if errorlevel 1 goto error

echo Step 3: Compiling DAO classes...
javac -cp "%CLASSPATH%" src/com/inventory/dao/CategoryDAO.java
javac -cp "%CLASSPATH%" src/com/inventory/dao/ProductDAO.java
if errorlevel 1 goto error

echo Step 4: Compiling GUI classes...
javac -cp "%CLASSPATH%" src/com/inventory/gui/CategoryDialog.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/ProductDialog.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/DashboardPanel.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/CategoryManagementPanel.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/ProductManagementPanel.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/MainFrame.java
if errorlevel 1 goto error

echo Step 5: Compiling main application...
javac -cp "%CLASSPATH%" src/com/inventory/InventorySystemApp.java
if errorlevel 1 goto error

echo.
echo ✅ Compilation successful!
echo.
echo Step 6: Running the application...
echo.
java -cp "%CLASSPATH%" com.inventory.InventorySystemApp

goto end

:error
echo.
echo ❌ Compilation failed! Check the errors above.
echo.
pause
exit /b 1

:end
echo.
echo Application closed.
pause 