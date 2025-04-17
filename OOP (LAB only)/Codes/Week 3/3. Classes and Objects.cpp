#include <iostream>
using namespace std;

class Car {
public:
    string brand;
    int modelYear;

    void showDetails() {
        cout << "Brand: " << brand << ", Model Year: " << modelYear << endl;
    }
};

int main() {
    Car car1; // Creating an object of Car
    car1.brand = "Honda";
    car1.modelYear = 2022;
    car1.showDetails();

    return 0;
}

