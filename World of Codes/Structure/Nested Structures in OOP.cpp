#include <iostream>
using namespace std;

struct Date {
    int day;
    char month[4];
    int year;
};

struct Student {
    int age;
    float height, weight;
    Date dob; // Nested structure
};

int main() {
    Student s;

    cout << "Enter Age: ";
    cin >> s.age;
    cout << "Enter Height: ";
    cin >> s.height;
    cout << "Enter Weight: ";
    cin >> s.weight;
    cout << "Enter Date of Birth (Day Month Year): ";
    cin >> s.dob.day >> s.dob.month >> s.dob.year;

    cout << "\nStudent Details:\n";
    cout << "Age: " << s.age << "\nHeight: " << s.height << "\nWeight: " << s.weight << endl;
    cout << "Date of Birth: " << s.dob.day << "-" << s.dob.month << "-" << s.dob.year << endl;

    return 0;
}

