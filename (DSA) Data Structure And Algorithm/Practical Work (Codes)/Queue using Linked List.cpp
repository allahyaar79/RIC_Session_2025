#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

int main() {
    Node* front = new Node{10, nullptr};
    Node* rear = front;
    rear->next = new Node{20, nullptr};
    rear = rear->next;

    cout << "Front data: " << front->data << endl;
    cout << "Next data: " << front->next->data << endl;
    return 0;
}
