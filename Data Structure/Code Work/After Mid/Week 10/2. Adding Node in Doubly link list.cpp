#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node* prev;
};

int main() {
    // Creating three nodes
    Node* head = new Node();    // first node
    Node* second = new Node();  // second node
    Node* third = new Node();   // third node

    // Assigning values and linking nodes (forward and backward)
    head->data = 10;
    head->next = second;
    head->prev = nullptr;       

    second->data = 20;
    second->next = third;
    second->prev = head;

    third->data = 30;
    third->next = nullptr;
    third->prev = second;

    // ? Add node at the beginning
    Node* newNode = new Node();
    newNode->data = 5;
    newNode->prev = nullptr;
    newNode->next = head;
    head->prev = newNode;
    head = newNode;  // Update head

    // Traversing the list forward
    Node* temp = head;
    cout << "List after inserting at beginning: ";
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}

