package javaapplication1;

public class ConstantsExample {
    // Mathematical constants
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    public static final double GOLDEN_RATIO = 1.61803398875;
    
    // Application-specific constants
    public static final int MAX_LOGIN_ATTEMPTS = 3;
    public static final String APPLICATION_NAME = "Student Management System";
    public static final double MINIMUM_PASSING_GRADE = 60.0;
    
    // Time-related constants
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;
    
    public static void main(String[] args) {
        // Demonstrate using constants in calculations
        double radius = 5.0;
        double circleArea = PI * radius * radius;
        System.out.printf("Area of circle with radius %.2f: %.2f%n", radius, circleArea);
        
        // Demonstrate using application constants
        System.out.println("Welcome to " + APPLICATION_NAME);
        System.out.println("Maximum login attempts allowed: " + MAX_LOGIN_ATTEMPTS);
        
        // Demonstrate using time constants
        int totalSeconds = 3665; // Example: 1 hour, 1 minute, 5 seconds
        int hours = totalSeconds / (SECONDS_PER_MINUTE * MINUTES_PER_HOUR);
        int minutes = (totalSeconds % (SECONDS_PER_MINUTE * MINUTES_PER_HOUR)) / SECONDS_PER_MINUTE;
        int seconds = totalSeconds % SECONDS_PER_MINUTE;
        
        System.out.printf("Time breakdown: %d hours, %d minutes, %d seconds%n",
                         hours, minutes, seconds);
        
        // Demonstrate using constants in grade calculation
        double studentGrade = 75.0;
        if (studentGrade >= MINIMUM_PASSING_GRADE) {
            System.out.println("Student has passed the course!");
        } else {
            System.out.println("Student needs to retake the course.");
        }
    }
} 