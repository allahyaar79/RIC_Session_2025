@echo off
echo Quick Test - Running Application
echo =================================
echo.

REM Set classpath
set CLASSPATH=src;mysql-connector-j-9.3.0/mysql-connector-j-9.3.0.jar

echo Testing application with current database settings...
echo.

java -cp "%CLASSPATH%" com.inventory.InventorySystemApp

echo.
echo Test completed.
pause 