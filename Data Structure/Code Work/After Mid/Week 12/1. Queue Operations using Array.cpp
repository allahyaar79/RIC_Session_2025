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

