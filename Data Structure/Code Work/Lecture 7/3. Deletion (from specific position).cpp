#include <iostream>
using namespace std;

int main() {
    int arr[10] = {1, 2, 3, 4, 5};
    int size = 5;
    int position = 2;  // Delete element at index 2 (value 3)

    // Shift elements to the left
    for (int i = position; i < size - 1; i++) {
        arr[i] = arr[i + 1];
    }

    size--;  // Decrease the size

    // Print updated array
    cout << "Array after deletion: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}

