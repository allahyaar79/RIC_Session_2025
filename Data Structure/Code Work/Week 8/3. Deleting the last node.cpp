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

    // Deleting the last node
    if (head == nullptr) {
        // Empty list
        cout << "List is empty." << endl;
    } else if (head->next == nullptr) {
        // Only one node
        delete head;
        head = nullptr;
    } else {
        // More than one node
        Node* prev = head;
        while (prev->next->next != nullptr) {
            prev = prev->next;
        }
        delete prev->next;       // delete the last node
        prev->next = nullptr;    // set second last's next to null
    }

    // Traversing the list after deletion
    cout << "After deleting last node: ";
    temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;

    return 0;
}

