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

    // Dequeue operation
    void dequeue() {
        if (front == -1 || front > rear) {
            cout << "Queue is Empty (Underflow)!" << endl;
            return;
        }
        cout << "Deleted: " << arr[front] << endl;
        front++;
        // Reset queue if all elements are dequeued
        if (front > rear) {
            front = -1;
            rear = -1;
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
    q.enqueue(40);
    q.enqueue(50);
    q.display();

    q.dequeue();
    q.dequeue();
    q.display();

    q.enqueue(60); // Should show "Queue is Full" as space isn't reused
    q.display();

    return 0;
}

