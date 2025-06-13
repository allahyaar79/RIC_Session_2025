@echo off
echo Inventory Management System - Improved Version
echo =============================================
echo.

REM Set classpath
set CLASSPATH=src;mysql-connector-j-9.3.0/mysql-connector-j-9.3.0.jar

echo Recompiling with improvements...

REM Compile the updated files
javac -cp "%CLASSPATH%" src/com/inventory/InventorySystemApp.java
javac -cp "%CLASSPATH%" src/com/inventory/gui/MainFrame.java  
javac -cp "%CLASSPATH%" src/com/inventory/gui/DashboardPanel.java

if errorlevel 1 (
    echo ❌ Compilation failed!
    pause
    exit /b 1
)

echo ✅ Compilation successful!
echo.
echo Starting improved application...
echo.

java -cp "%CLASSPATH%" -Dfile.encoding=UTF-8 com.inventory.InventorySystemApp

echo.
echo Application closed.
pause 