@FunctionalInterface
interface Demo {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Demo d = (a, b) -> { return a + b; };
        System.out.println(d.add(10, 20));
    }
}
