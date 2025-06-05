#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node* prev;  // Added for doubly linked list
};

int main() {
    // Creating three nodes
    Node* head = new Node();    // first node
    Node* second = new Node();  // second node
    Node* third = new Node();   // third node

    // Assigning values and linking nodes (forward and backward)
    head->data = 10;
    head->next = second;
    head->prev = nullptr;       // No previous for head

    second->data = 20;
    second->next = third;
    second->prev = head;

    third->data = 30;
    third->next = nullptr;      // Last node's next is null
    third->prev = second;

    // Traversing the list forward
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}

