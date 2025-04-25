#include <iostream>  // Includes the input-output stream library
using namespace std;  // To use the standard namespace for easier access to standard library functions

// Define a structure to represent a node in the queue
struct Node {
    int data;          // Data stored in the node (integer)
    Node* next = nullptr;  // Pointer to the next node, initially null (no next node)
};

// Queue class implementation using a linked list
class Queue {
    Node *front = nullptr, *rear = nullptr;  // Front and rear pointers, initialized to nullptr

public:
    // Method to add an element to the queue
    void enqueue(int x) {
        Node* n = new Node{ x };  // Create a new node with the value x
        if (rear) rear->next = n;  // If rear is not null, link the rear node's next to the new node
        rear = n;                  // Update rear to point to the new node
        if (!front) front = n;     // If the queue is empty, set front to the new node
    }

    // Method to remove an element from the queue
    void dequeue() {
        if (front) {               // Check if the queue is not empty
            Node* temp = front;    // Store the current front node temporarily
            front = front->next;   // Move front pointer to the next node in the queue
            delete temp;           // Delete the old front node to free memory
        }
    }

    // Method to display all elements in the queue
    void display() {
        for (Node* temp = front; temp; temp = temp->next)  // Iterate through the queue from front to rear
            cout << temp->data << " ";  // Print the data of each node
        cout << endl;  // Print a newline after displaying all elements
    }
};

int main() {
    Queue q;  // Create an instance of the Queue class
    q.enqueue(10);  // Enqueue the value 10
    q.enqueue(20);  // Enqueue the value 20
    q.display();  // Display the elements in the queue (10 20)
    q.dequeue();  // Dequeue an element from the queue (removes 10)
    q.display();  // Display the remaining elements in the queue (20)
}

