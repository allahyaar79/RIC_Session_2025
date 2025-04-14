import javax.swing.JOptionPane;

public class JOptionPaneExample {
    public static void main(String[] args) {
        // Reading a string
        String name = JOptionPane.showInputDialog("Enter your name:");
        
        // Reading an integer
        String ageStr = JOptionPane.showInputDialog("Enter your age:");//35
        int age = Integer.parseInt(ageStr);//explicit type casting
        
        // Reading a double
        String heightStr = JOptionPane.showInputDialog("Enter your height (in meters):");
        double height = Double.parseDouble(heightStr);//explicit type casting
        
        // Reading a boolean using a confirmation dialog
        int choice = JOptionPane.showConfirmDialog(null, 
            "Are you a student?", 
            "Student Status", 
            JOptionPane.YES_NO_OPTION);
        boolean isStudent = (choice == JOptionPane.YES_OPTION);//yes no option
        
        // Display the input using a message dialog
        String message = String.format("You entered:\n" +
            "Name: %s\n" +
            "Age: %d\n" +
            "Height: %.2f\n" +
            "Student: %s", 
            name, age, height, isStudent ? "Yes" : "No");
            
        JOptionPane.showMessageDialog(null, message, "Input Summary", 
            JOptionPane.INFORMATION_MESSAGE);
    }
} 