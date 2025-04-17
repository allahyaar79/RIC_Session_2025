#include <iostream>
using namespace std;

class Person {
private:
    string name;  // Data member
    int age;      // Data member

public:
    void setDetails(string n, int a) {  // Member function
        name = n;
        age = a;
    }

    void display() {  // Member function
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

int main() {
    Person p;
    p.setDetails("Sara", 25);  // Calling member function
    p.display();

    return 0;
}

