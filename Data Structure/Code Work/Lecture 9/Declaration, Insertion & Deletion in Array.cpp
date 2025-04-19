#include <iostream>
using namespace std;

int main() {
    const int SIZE = 100;
    int arr[SIZE]; // Declaration of array
    int n = 0; // Current number of elements

    // Insertion - Adding 3 elements
    arr[n++] = 10;
    arr[n++] = 20;
    arr[n++] = 30;

    cout << "Array after insertion: ";
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    // Deletion - Delete element at index 1 (which is 20)
    int delIndex = 1;
    for(int i = delIndex; i < n - 1; i++) { // 1=1; 1<2; 
        arr[i] = arr[i + 1];
    }
    n--; // Reduce size

    cout << "Array after deletion: ";
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}

