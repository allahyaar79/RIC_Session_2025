package javaapplication1;

public class IdentifiersExample {
    // Class-level variables (camelCase)
    private String studentName;
    private int studentAge;
    private double studentGPA;
    
    // Constants (UPPER_SNAKE_CASE)
    private static final int MAX_STUDENT_AGE = 100;
    private static final double MAX_GPA = 4.0;
    
    // Constructor (PascalCase)
    public IdentifiersExample(String studentName, int studentAge, double studentGPA) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGPA = studentGPA;
    }
    
    // Methods (camelCase)
    public void displayStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + studentName);
        System.out.println("Age: " + studentAge);
        System.out.println("GPA: " + studentGPA);
    }
    
    // Boolean methods start with 'is', 'has', 'can', etc.
    public boolean isStudentEligible() {
        return studentAge >= 18 && studentGPA >= 2.0;
    }
    
    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Create an instance with meaningful variable names
        IdentifiersExample student = new IdentifiersExample("John Doe", 20, 3.5);
        
        // Display student information
        student.displayStudentInfo();
        
        // Check eligibility
        if (student.isStudentEligible()) {
            System.out.println("Student is eligible for the program.");
        } else {
            System.out.println("Student is not eligible for the program.");
        }
    }
} 