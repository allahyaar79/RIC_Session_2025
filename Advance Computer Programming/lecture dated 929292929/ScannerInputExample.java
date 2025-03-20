package javaapplication1;

import java.util.Scanner;

public class ScannerInputExample {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Get name (String input)
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        
        // Get age (Integer input)
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();
        
        // Get height (Double input)
        System.out.print("Please enter your height in meters: ");
        double height = scanner.nextDouble();
        
        // Display the collected information
        System.out.println("\nCollected Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.printf("Height: %.2f meters%n", height);
        
        // Close the scanner
        scanner.close();
    }
} 