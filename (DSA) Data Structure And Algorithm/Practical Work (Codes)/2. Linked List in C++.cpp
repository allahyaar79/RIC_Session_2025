#include <iostream>
using namespace std;

int main() {
    // Creating nodes
    int a = 10, b = 20, c = 30;

    // Creating pointers to mimic linked list
    int* node1 = &a;
    int* node2 = &b;
    int* node3 = &c;

    // Displaying values (like a linked list)
    cout << "List: " << *node1 << " " << *node2 << " " << *node3;

    return 0;
}

