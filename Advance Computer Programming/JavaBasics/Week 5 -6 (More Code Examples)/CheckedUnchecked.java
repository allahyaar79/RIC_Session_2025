import java.io.*;

public class CheckedUnchecked {
    public static void main(String[] args) {
        // Unchecked Exception
        int x = 5 / 0; // ArithmeticException

        // Checked Exception - must be caught or declared
        try {
            FileReader fr = new FileReader("file.txt"); // FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
