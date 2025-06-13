@echo off
echo Debug Mode - Inventory Management System
echo ========================================
echo.

REM Set classpath
set CLASSPATH=src;mysql-connector-j-9.3.0/mysql-connector-j-9.3.0.jar

echo Killing any existing Java processes...
taskkill /f /im java.exe >nul 2>&1

echo.
echo Starting application with detailed logging...
echo.
echo *** If you see errors below, that's the issue ***
echo.

REM Run with detailed output
java -cp "%CLASSPATH%" -Djava.awt.headless=false -Dfile.encoding=UTF-8 com.inventory.InventorySystemApp

echo.
echo Application ended. Check above for any errors.
echo.
pause 