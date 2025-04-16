class CarConstructor {
    //create variable of string type
    String color;

    // Constructor
    //className (datatype parameterName) {
    CarConstructor(String carColor) {//carColor = Red
        color = carColor;
    }

//getter function
    public void displayColor() {
        System.out.println("Car color is: " + color);
    }
}

public class Main {
    public static void main(String[] args) {
        //className objectName = new ClassName('value')
CarConstructor myCar;
        myCar = new CarConstructor("Red"); // Object creation using constructor
        //calling class function (method)
        myCar.displayColor();
    }
}


//setter (accept value from user) getter (display value)
//int a, b, c;
//a = 10, b = 20, c = 30;
