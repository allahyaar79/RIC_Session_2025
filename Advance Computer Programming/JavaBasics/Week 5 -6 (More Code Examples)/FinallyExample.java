public class FinallyExample {
    public static void main(String[] args) {
        try {
            int num = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught exception.");
        } finally {
            System.out.println("Finally block always runs.");
        }
    }
}
