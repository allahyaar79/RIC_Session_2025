#include <iostream>
using namespace std;

class Student {
public:
    string name;
    void display() {
        cout << "Name: " << name << endl;
    }
};

int main() {
    Student s[2];  //array "s" use as a object of class "Student"
    s[0].name = "Ali";
    s[1].name = "Sara";
    
	//Class Name* pointer variable name = object name;
    Student* ptr = s;  // Declaration of object as pointer

    for(int i = 0; i < 2; i++) {
        ptr[i].display();
    }

    return 0;
}

