@echo off
echo Inventory Management System
echo =========================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH.
    echo Please install Java 11 or higher and try again.
    pause
    exit /b 1
)

echo Starting Inventory Management System...
echo.

REM Try to run with Maven first
if exist pom.xml (
    echo Using Maven to run the application...
    mvn exec:java -Dexec.mainClass="com.inventory.InventorySystemApp"
) else (
    REM Fallback to direct Java execution
    echo Running with Java directly...
    if exist target\inventory-management-system-1.0.0-jar-with-dependencies.jar (
        java -jar target\inventory-management-system-1.0.0-jar-with-dependencies.jar
    ) else (
        echo Error: No executable JAR found. Please build the project first.
        echo Run: mvn clean package
        pause
        exit /b 1
    )
)

pause 