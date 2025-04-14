import java.util.Scanner;//header file #include <iostream>

public class ScannerExample {
    public static void main(String[] args) {
        // Create a Scanner object
        //ClassName objectName = new ClassName();
        Scanner scanner = new Scanner(System.in);//Scanner scanner = new Scanner(System.in);
        
        // Reading a string
        System.out.println("Enter your name: ");//cout << "Enter your name: ";
        String name = scanner.nextLine();//cin >> name;
        
        // Reading an integer
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();//cin >> age;
        
        // Reading a double
        System.out.println("Enter your height (in meters): ");
        double height = scanner.nextDouble();//cin >> height;
        
        // Reading a single character
        System.out.println("Enter a character: ");//cout << "Enter a character: ";
        char character = scanner.next().charAt(0);//cin >> character;
        
        // Display the input
        System.out.println("\nYou entered:");//cout << "\nYou entered:" << endl;
        System.out.println("Name: " + name);//cout << "Name: " << name << endl;
        System.out.println("Age: " + age);//cout << "Age: " << age << endl;
        System.out.println("Height: " + height);//cout << "Height: " << height << endl;
        System.out.println("Character: " + character);
        
        // Close the scanner
        scanner.close();
    }
} 