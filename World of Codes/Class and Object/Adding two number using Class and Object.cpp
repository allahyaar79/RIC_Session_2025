#include <iostream>
using namespace std;

// Class definition
class Adder {
private:
    int num1, num2;

public:
    // Method to get input from user
    void getInput() {
        cout << "Enter first number: ";
        cin >> num1;
        cout << "Enter second number: ";
        cin >> num2;
    }

    // Method to add numbers
    int add() {
        return num1 + num2;
    }
};

// Main function
int main() {
    Adder obj;            // Create object of class Adder
    obj.getInput();       // Take input
    int sum = obj.add();  // Call add method
    cout << "Sum = " << sum << endl;
    return 0;
}

