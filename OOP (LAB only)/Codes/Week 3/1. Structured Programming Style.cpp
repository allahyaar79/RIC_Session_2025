#include <iostream>
using namespace std;

// Structured approach using functions and variables
void displayStudent(string name, int age) {
    cout << "Name: " << name << ", Age: " << age << endl;
}

int main() {
    string name = "Ali";
    int age = 20;
    displayStudent(name, age);
    return 0;
}

