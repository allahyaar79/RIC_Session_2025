#include <iostream>
using namespace std;

int main() {
    int number = 42;       
    int* ptr = &number;     

    cout << "Value of number: " << number << endl;
    cout << "Address of number (using &): " << &number << endl;
    cout << "Address stored in pointer: " << ptr << endl;
    cout << "Value using pointer: " << *ptr << endl;

    return 0;
}
