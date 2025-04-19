import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter your full name: ");
        String name = input.nextLine();

        // Display details
        System.out.println("Length of name: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());
        System.out.println("First character: " + name.charAt(0));
        System.out.println("Last character: " + name.charAt(name.length() - 1));
        System.out.println("Welcome, " + name + "!");
    }
}
