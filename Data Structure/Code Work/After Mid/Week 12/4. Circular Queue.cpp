#include <iostream>
using namespace std;

#define SIZE 5

class CircularQueue {
private:
    int arr[SIZE];
    int front, rear;

public:
    CircularQueue() {
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int value) {
        if ((rear + 1) % SIZE == front) {
            cout << "Queue is Full (Overflow)!" << endl;
            return;
        }
        if (front == -1) { // First insertion
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % SIZE;
        }
        arr[rear] = value;
        cout << "Inserted: " << value << endl;
    }

    // Dequeue operation
    void dequeue() {
        if (front == -1) {
            cout << "Queue is Empty (Underflow)!" << endl;
            return;
        }
        cout << "Deleted: " << arr[front] << endl;
        if (front == rear) {
            // Only one element was present
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
    }

    // Display the queue
    void display() {
        if (front == -1) {
            cout << "Queue is Empty!" << endl;
            return;
        }

        cout << "Queue elements: ";
        int i = front;
        while (true) {
            cout << arr[i] << " ";
            if (i == rear) break;
            i = (i + 1) % SIZE;
        }
        cout << endl;
    }
};

int main() {
    CircularQueue cq;

    cq.enqueue(10);
    cq.enqueue(20);
    cq.enqueue(30);
    cq.enqueue(40);
    cq.enqueue(50); // Should show full on next insert

    cq.display();

    cq.dequeue();
    cq.dequeue();

    cq.display();

    cq.enqueue(60);
    cq.enqueue(70); // Should wrap around

    cq.display();

    return 0;
}

