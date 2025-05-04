class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat(); // Parent reference, Child object
        a.sound(); // Calls Cat's version (dynamic dispatch)
    }
}
