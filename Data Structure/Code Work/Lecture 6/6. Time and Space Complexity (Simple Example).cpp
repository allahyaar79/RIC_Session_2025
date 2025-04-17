#include <iostream>
using namespace std;

void printArray(int arr[], int n) {
    // Time Complexity: O(n) — Loop runs 'n' times
    // Space Complexity: O(1) — No extra space used
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
}

int main() {
    int arr[5] = {2, 4, 6, 8, 10};
    printArray(arr, 5);
    return 0;
}

