#include <iostream>
using namespace std;

#define SIZE 5

class Queue {
private:
    int arr[SIZE];
    int front, rear;

public:
    Queue() {
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int value) {
        if (rear == SIZE - 1) {
            cout << "Queue is Full (Overflow)!" << endl;
            return;
        }
        if (front == -1) front = 0; // first insertion
        rear++;
        arr[rear] = value;
        cout << "Inserted: " << value << endl;
    }

    // Get Front element (peek)
    void getFront() {
        if (front == -1 || front > rear) {
            cout << "Queue is Empty! No front element." << endl;
        } else {
            cout << "Front element: " << arr[front] << endl;
        }
    }

    // Display queue
    void display() {
        if (front == -1 || front > rear) {
            cout << "Queue is Empty!" << endl;
            return;
        }
        cout << "Queue elements: ";
        for (int i = front; i <= rear; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    Queue q;

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    q.display();
    q.getFront();  // Shows front element without removing it

    return 0;
}

