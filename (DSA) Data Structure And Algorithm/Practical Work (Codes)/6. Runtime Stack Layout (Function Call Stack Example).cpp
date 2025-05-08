#include <iostream>
using namespace std;

void display() {
    int x = 5;  // Stored in stack
    cout << "Inside function: " << x << endl;
}

int main() {
    display();
    return 0;
}

