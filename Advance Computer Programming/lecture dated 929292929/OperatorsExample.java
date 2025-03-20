package javaapplication1;

public class OperatorsExample {
    public static void main(String[] args) {
        // Arithmetic Operators
        System.out.println("Arithmetic Operators:");
        int a = 10;
        int b = 3;
        
        System.out.println("Addition (+): " + (a + b));      // 13
        System.out.println("Subtraction (-): " + (a - b));   // 7
        System.out.println("Multiplication (*): " + (a * b)); // 30
        System.out.println("Division (/): " + (a / b));      // 3
        System.out.println("Modulus (%): " + (a % b));       // 1
        
        // Relational Operators
        System.out.println("\nRelational Operators:");
        System.out.println("Equal to (==): " + (a == b));    // false
        System.out.println("Not equal to (!=): " + (a != b)); // true
        System.out.println("Greater than (>): " + (a > b));  // true
        System.out.println("Less than (<): " + (a < b));     // false
        System.out.println("Greater than or equal to (>=): " + (a >= b)); // true
        System.out.println("Less than or equal to (<=): " + (a <= b));    // false
        
        // Logical Operators
        System.out.println("\nLogical Operators:");
        boolean x = true;
        boolean y = false;
        boolean z = true;
        
        System.out.println("Logical AND (&&): " + (x && y));  // false
        System.out.println("Logical OR (||): " + (x || y));   // true
        System.out.println("Logical NOT (!): " + (!x));       // false
        
        // Compound logical expressions
        System.out.println("\nCompound Logical Expressions:");
        System.out.println("(x && y) || z: " + ((x && y) || z));  // true
        System.out.println("!(x && y): " + (!(x && y)));          // true
        
        // Increment and Decrement Operators
        System.out.println("\nIncrement and Decrement Operators:");
        int counter = 5;
        System.out.println("Original value: " + counter);
        System.out.println("Post-increment: " + (counter++));  // prints 5, then adds 1
        System.out.println("After post-increment: " + counter);
        System.out.println("Pre-increment: " + (++counter));   // adds 1, then prints 7
        System.out.println("After pre-increment: " + counter);
        
        // Assignment Operators
        System.out.println("\nAssignment Operators:");
        int num = 10;
        System.out.println("Original value: " + num);
        num += 5;  // num = num + 5
        System.out.println("After += 5: " + num);
        num -= 3;  // num = num - 3
        System.out.println("After -= 3: " + num);
        num *= 2;  // num = num * 2
        System.out.println("After *= 2: " + num);
        num /= 4;  // num = num / 4
        System.out.println("After /= 4: " + num);
    }
} 