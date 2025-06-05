/*
We use polymorphism to allow a base class pointer or reference
to call derived class methods, enabling dynamic behavior at runtime.

It helps in writing flexible and reusable code by using
a common interface for different data types or classes.
*/
#include <iostream>          
using namespace std;         
// Base class
class Animal {
public:
    // Virtual function to allow overriding in derived class
    virtual void sound() {
        cout << "Animal makes a sound" << endl;  // Default message if not overridden
    }
};
// Derived class
class Dog : public Animal
//Defines a child class Dog that inherits publicly from Animal.
 {
public:
    // Override the base class sound function
    void sound() override {
        cout << "Dog barks" << endl;  // Custom message for Dog class
    }
};
int main() {
    Animal* a;   // Declare a pointer of base class type
    Dog d;       // Create an object of the derived class Dog
    a = &d;      // Base class pointer points to the derived class object (upcasting)
    a->sound();  // Calls the overridden function in Dog class due to virtual function (Output: Dog barks)
    return 0;    // Return 0 to indicate successful execution
}

