// Abstract class
abstract class Animal {
    abstract void makeSound(); // abstract method

    void sleep() {
        System.out.println("Zzz...");
    }
}

// Subclass
class Cow extends Animal {
    void makeSound() {
        System.out.println("Cow says Moo!");
    }
}

public class Main {
    public static void main(String[] args) {
        Cow c = new Cow();
        c.makeSound();  // Implementation from Cow
        c.sleep();      // Inherited from Animal
    }
}
