#include <iostream>
using namespace std;

int main() {
    int stack[3];
    int top = -1;

    // Push
    top++;
    stack[top] = 10;

    top++;
    stack[top] = 20;

    top++;
    stack[top] = 30;

    // Display
    cout << "Stack: ";
    cout << stack[2] << " " << stack[1] << " " << stack[0];

    // Pop one item
    top--;

    // Display after pop
    cout << "\nAfter pop: ";
    cout << stack[1] << " " << stack[0];

    return 0;
}

