#include <iostream>
using namespace std;

int main() {
    int arr[5] = {5, 2, 4, 1, 3};

    for (int i = 1; i < 5; i++) {
        int key = arr[i];
        int j = i - 1;

        // Move bigger elements to the right
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }

    for (int i = 0; i < 5; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}

