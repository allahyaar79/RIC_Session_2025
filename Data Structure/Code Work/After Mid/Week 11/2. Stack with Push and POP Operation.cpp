#include <iostream>
using namespace std;

class Stack {
private:
    int arr[5];  // Fixed-size array
    int top;

public:
    Stack() {
        top = -1;  // Stack is initially empty
    }

    // Push operation
    void push(int value) {
        if (top < 4) {  // Check if stack has space
            top++;
            arr[top] = value;
            cout << value << " pushed to stack.\n";
        } else {
            cout << "Stack is full. Cannot push " << value << ".\n";
        }
    }

    // Pop operation
    void pop() {
        if (top >= 0) {  // Check if stack is not empty
            cout << arr[top] << " popped from stack.\n";
            top--;
        } else {
            cout << "Stack is empty. Nothing to pop.\n";
        }
    }
};

// Main function
int main() {
    Stack s;

    s.push(10);
    s.push(20);
    s.push(30);

    s.pop();  // Should remove 30
    s.pop();  // Should remove 20

    return 0;
}

