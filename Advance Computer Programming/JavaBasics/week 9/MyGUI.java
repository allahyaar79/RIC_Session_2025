import javax.swing.*;

public class MyGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple GUI");
        JButton button = new JButton("Click Me!");
        JTextField textField = new JTextField("Type Here");
        JLabel label = new JLabel("Hello, Java GUI!");

        // Set positions
        frame.setLayout(null);  // Manual layout
        label.setBounds(20, 20, 150, 30);
        textField.setBounds(20, 60, 150, 30);
        button.setBounds(20, 100, 100, 30);

        // Add to frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
