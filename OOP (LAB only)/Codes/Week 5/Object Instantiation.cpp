#include <iostream>
using namespace std;

class Car {
public:
    void display() {
        cout << "This is a car." << endl;
    }
};

int main() {
    Car myCar;  // Object Instantiation
    myCar.display();
    return 0;
}

