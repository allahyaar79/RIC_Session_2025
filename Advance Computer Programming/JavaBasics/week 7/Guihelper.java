import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Helper class to build GUI components
class BasicSwingGUI {
    // Method to create a JLabel
    public static JLabel createLabel(String text) {
        return new JLabel(text);
    }

    // Method to create a JTextField
    public static JTextField createTextField(int columns) {
        return new JTextField(columns);
    }

    // Method to create a JButton with an ActionListener
    public static JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }
}

// Main GUI class
public class Guihelper {

    // Method to create and show GUI
    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Greeting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLayout(new FlowLayout());

        // Create GUI components using helper class
        JLabel nameLabel = BasicSwingGUI.createLabel("Enter your name:");
        JTextField nameField = BasicSwingGUI.createTextField(15);
        JLabel resultLabel = BasicSwingGUI.createLabel("");

        // Button with action to show greeting
        JButton greetButton = BasicSwingGUI.createButton("Greet", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (!name.isEmpty()) {
                    resultLabel.setText("Hello, " + name + "!");
                } else {
                    resultLabel.setText("Please enter a name.");
                }
            }
        });

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(greetButton);
        frame.add(resultLabel);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Run GUI creation in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}