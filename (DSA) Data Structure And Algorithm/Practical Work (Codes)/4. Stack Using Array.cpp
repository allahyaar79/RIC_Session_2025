#include <iostream>
using namespace std;

int main() {
    int stack[5];     // array to hold stack elements
    int top = -1;     // stack is empty

    // Push 10
    top++;
    stack[top] = 10;

    // Push 20
    top++;
    stack[top] = 20;

    // Pop top element
    top--;

    // Display remaining elements
    cout << "Stack elements:\n";
    for (int i = 0; i <= top; i++)
	
	
	 {
        cout << stack[i] << " ";
    }

    return 0;
}

