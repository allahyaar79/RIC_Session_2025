#include <iostream>
using namespace std;

int main() {
    char name[] = "Ali";
    char* ptr = name;  // Pointer to character array

    cout << "Characters using pointer: ";
    while(*ptr != '\0') {
        cout << *ptr << " ";
        ptr++;
    }
    return 0;
}

