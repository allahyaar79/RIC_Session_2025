public class ShorthandOperatorsExample {
    public static void main(String[] args) {
        int a = 10;

        // Using shorthand operators
        a += 5;  // same as a = a + 5
        System.out.println("After += : " + a);  // 15

        a -= 3;  // same as a = a - 3
        System.out.println("After -= : " + a);  // 12

        a *= 2;  // same as a = a * 2
        System.out.println("After *= : " + a);  // 24

        a /= 4;  // same as a = a / 4
        System.out.println("After /= : " + a);  // 6

        a %= 5;  // same as a = a % 5
        System.out.println("After %= : " + a);  // 1
    }
}
