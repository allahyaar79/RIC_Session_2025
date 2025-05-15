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

    // Traversing the list
    cout << "Original list: ";
    Node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;

    // Deleting the first node
    Node* toDelete = head;     // node to delete
    head = head->next;         // move head to next node
    delete toDelete;           // free memory

    // Traversing the updated list
    cout << "After deleting first node: ";
    temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;

    return 0;
}

