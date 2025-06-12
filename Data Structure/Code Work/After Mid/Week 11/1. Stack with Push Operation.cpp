/*A stack is a linear data structure that 
follows the LIFO principle — Last In, First Out*/

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
};

// Main function
int main() {
    Stack s;

    s.push(10);
    s.push(20);
    s.push(30);

    return 0;
}

