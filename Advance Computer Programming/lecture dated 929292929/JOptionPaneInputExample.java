package javaapplication1;

import javax.swing.JOptionPane;

public class JOptionPaneInputExample {
    public static void main(String[] args) {
        // Get name using JOptionPane
        String name = JOptionPane.showInputDialog(
            null,
            "Please enter your name:",
            "Name Input",
            JOptionPane.QUESTION_MESSAGE
        );
        
        // Get age using JOptionPane and convert to int
        String ageStr = JOptionPane.showInputDialog(
            null,
            "Please enter your age:",
            "Age Input",
            JOptionPane.QUESTION_MESSAGE
        );
        int age = Integer.parseInt(ageStr);
        
        // Get height using JOptionPane and convert to double
        String heightStr = JOptionPane.showInputDialog(
            null,
            "Please enter your height in meters:",
            "Height Input",
            JOptionPane.QUESTION_MESSAGE
        );
        double height = Double.parseDouble(heightStr);
        
        // Display the collected information
        String message = String.format(
            "Collected Information:\n" +
            "Name: %s\n" +
            "Age: %d\n" +
            "Height: %.2f meters",
            name, age, height
        );
        
        JOptionPane.showMessageDialog(
            null,
            message,
            "Information Summary",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
} 