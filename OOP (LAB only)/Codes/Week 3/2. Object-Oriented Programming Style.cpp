#include <iostream>
using namespace std;

// Object-oriented approach using a class and object
class Student {
public:
    string name;
    int age;

    void display() {
        cout << "Name: " << name << ", Age: " << age << endl;
    }
};

int main() {
    Student s;
    s.name="Ali";
    s.age=20;
 	s.display()
    return 0;
}

