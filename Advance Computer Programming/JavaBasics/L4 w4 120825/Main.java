// Interface
interface Animal {
    void eat();       // implicitly public and abstract
    void makeSound();
}

// Implementing class
class Dog implements Animal {
    public void eat() {
        System.out.println("Dog eats bones.");
    }

    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.makeSound();
    }
}
