#include <iostream>
using namespace std;

int main() {
    int* arr = new int[3];  // Original size
    arr[0] = 1; arr[1] = 2; arr[2] = 3;

    // Increase size
    int* newArr = new int[5];
    for (int i = 0; i < 3; i++) {
        newArr[i] = arr[i];  // Copy old values
    }
    newArr[3] = 4;
    newArr[4] = 5;

    // Print new array
    for (int i = 0; i < 5; i++) {
        cout << newArr[i] << " ";
    }

    delete[] arr; // Free old memory
    delete[] newArr; // Optional: free new memory if done

    return 0;
}

