public class AdvantageExample {
    public static void main(String[] args) {
        try {
            int[] arr = new int[3];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled error, program continues...");
        }
        System.out.println("Program ends gracefully.");
    }
}
