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

   int key = 20;
    Node* temp = head;
    int pos = 1;

    // Search loop
    while (temp != NULL) {
        if (temp->data == key) {
            cout << "Value " << key << " found at position " << pos << endl;
            return 0;
        }
        temp = temp->next;
        pos++;
    }

    cout << "Value " << key << " not found." << endl;
    return 0;
}
