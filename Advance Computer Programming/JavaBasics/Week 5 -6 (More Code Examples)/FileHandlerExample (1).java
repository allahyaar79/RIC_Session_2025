import java.io.*;
import java.util.Scanner;

public class FileHandlerExample {
    public static void main(String[] args) {
        String fileName = "students.txt";
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create and write to the file
        try {
            FileWriter writer = new FileWriter(fileName, true); // append mode
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            writer.write("Name: " + name + ", ID: " + id + "\n");
            System.out.println("Student data written to file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Step 2: Read from the file
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader(fileName);
            bufferedReader = new BufferedReader(reader);
            System.out.println("\nReading file content:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        } finally {
            // Ensure resources are closed
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing the file reader.");
            }
        }
    }
}
