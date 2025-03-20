package javaapplication1;

public class PrimitiveDataTypesExample {
    public static void main(String[] args) {
        // Integer types
        byte smallNumber = 127;                    // 8-bit, range: -128 to 127
        short mediumNumber = 32000;                // 16-bit, range: -32,768 to 32,767
        int regularNumber = 2147483647;            // 32-bit, most commonly used
        long largeNumber = 9223372036854775807L;   // 64-bit, note the 'L' suffix
        
        // Floating-point types
        float decimalNumber = 3.14159f;            // 32-bit, note the 'f' suffix
        double preciseDecimal = 3.14159265359;     // 64-bit, more precise
        
        // Character type
        char singleCharacter = 'A';                // 16-bit Unicode character
        char unicodeChar = '\u0041';               // Same as 'A' in Unicode
        
        // Boolean type
        boolean isTrue = true;                     // true or false
        
        // Display all values
        System.out.println("Integer Types:");
        System.out.println("byte: " + smallNumber);
        System.out.println("short: " + mediumNumber);
        System.out.println("int: " + regularNumber);
        System.out.println("long: " + largeNumber);
        
        System.out.println("\nFloating-point Types:");
        System.out.println("float: " + decimalNumber);
        System.out.println("double: " + preciseDecimal);
        
        System.out.println("\nCharacter Type:");
        System.out.println("char: " + singleCharacter);
        System.out.println("Unicode char: " + unicodeChar);
        
        System.out.println("\nBoolean Type:");
        System.out.println("boolean: " + isTrue);
        
        // Demonstrate type conversion
        System.out.println("\nType Conversion Examples:");
        int convertedFromByte = smallNumber;       // byte to int (widening)
        byte convertedToByte = (byte)regularNumber; // int to byte (narrowing)
        System.out.println("Converted from byte to int: " + convertedFromByte);
        System.out.println("Converted from int to byte: " + convertedToByte);
    }
} 