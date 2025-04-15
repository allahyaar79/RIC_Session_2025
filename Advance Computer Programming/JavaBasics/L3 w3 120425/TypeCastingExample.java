public class TypeCastingExample {
    public static void main(String[] args) {
        // Implicit casting (int to double)
        int num1 = 10;
        double result1 = num1;  // automatic conversion
        System.out.println("Implicit casting (int to double): " + result1);

        // Explicit casting (double to int)
        double num2 = 12.56;
        int result2 = (int) num2;  // manual conversion
        System.out.println("Explicit casting (double to int): " + result2);
    }
}
