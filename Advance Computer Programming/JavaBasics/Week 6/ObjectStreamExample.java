//object serialization 
import java.io.*;


class Person implements Serializable {
    String name;
    int age;
    Person(String name, int age) { this.name = name; this.age = age; }
}

public class ObjectStreamExample {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));
        oos.writeObject(new Person("Alice", 30));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));
        Person p = (Person) ois.readObject();
        System.out.println("Name: " + p.name + ", Age: " + p.age);
        ois.close();
    }
}
