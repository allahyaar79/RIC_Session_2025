#include <iostream>
using namespace std;

struct Student {
    string name;
    int age;
};

int main() {
    Student students[3] = {}; // All object elements are default initialized

    for (int i = 0; i < 3; i++) {
        cout << "Name: " << students[i].name << ", Age: " << students[i].age << endl;
    }

    return 0;
}

