#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

int main() {
    // Creating three nodes
    Node* head = new Node();    // first node
    Node* second = new Node();  // second node
    Node* third = new Node();   // third node

    // Assigning values and linking nodes
    head->data = 10;
    head->next = second;

    second->data = 20;
    second->next = third;

    third->data = 30;
    third->next = nullptr;  // end of list

    // Traversing the list before deletion
    cout << "Original list: ";
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;

    // Deleting node with a given value
    int valueToDelete = 20;
    Node* current = head;
    Node* prev = nullptr;

    // Case 1: If head node itself holds the value
    if (head != nullptr && head->data == valueToDelete) {
        Node* toDelete = head;
        head = head->next;
        delete toDelete;
    } else {
        // Case 2: Search for the node to delete
        while (current != nullptr && current->data != valueToDelete) {
            prev = current;
            current = current->next;
        }

        if (current != nullptr) {
            // Node with value found
            prev->next = current->next;
            delete current;
        } else {
            cout << "Value " << valueToDelete << " not found in the list." << endl;
        }
    }

    // Traversing the list after deletion
    cout << "After deleting value " << valueToDelete << ": ";
    temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;

    return 0;
}

