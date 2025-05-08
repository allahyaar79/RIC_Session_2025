#include <iostream>
using namespace std;

class Person {
public:
    string name;  // Instance variable
    int age;
};

int main() {
    Person p;
    p.name = "Ali";
    p.age = 25;
    cout << p.name << " is " << p.age << " years old." << endl;
    return 0;
}

