#include <iostream>
using namespace std;

int main() {
    int arr[3] = {10, 20, 30};
    int* ptr = arr;  // Pointer to integer array

    cout << "Values using pointer: ";
    for(int i = 0; i < 3; i++) {
        cout << *(ptr + i) << " ";     //previous *ptr [i]
    }
    return 0;
}

