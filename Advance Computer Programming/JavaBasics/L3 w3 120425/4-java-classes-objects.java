// Define a class named Car
public class Car {
    // Fields (properties)
    String brand;
    int year;

    // Method
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create an object of Car
        Car myCar = new Car();

        // Set values to the object's fields
        myCar.brand = "Toyota";
        myCar.year = 2020;

        // Call the method using the object
        myCar.displayInfo();
    }
}
