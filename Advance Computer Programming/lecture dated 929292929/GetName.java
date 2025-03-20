package javaapplication1;

import java.util.Scanner;

public class GetName {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for their name
        System.out.print("Please enter your name: ");
        
        // Read the name from the console
        String name = scanner.nextLine();
        
        // Display the name
        System.out.println("Hello, " + name + "!");
        
        // Close the scanner
        scanner.close();
    }
} 