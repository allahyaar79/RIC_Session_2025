#include <iostream>
using namespace std;

int main() {
    int arr[10] = {1, 2, 3, 5, 6};  // Initial array with 5 elements
    int size = 5;                   // Current size of array
    int position = 3;               // Position to insert at (index 3)
    int element = 4;                // Element to insert

    // Shift elements to the right
    for (int i = size; i > position; i--) {
        arr[i] = arr[i - 1];
    }

    arr[position] = element;  // Inserting the element
    size++;  // Increase the size

    // Print array
    cout << "Array after insertion: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}

