#include <iostream>
using namespace std;

int main() {
    int* arr = new int[5]{10, 20, 30, 40, 50};

    // Decrease size to 3
    int* smallerArr = new int[3];
    for (int i = 0; i < 3; i++) {
        smallerArr[i] = arr[i];
    }

    // Print resized array
    for (int i = 0; i < 3; i++) {
        cout << smallerArr[i] << " ";
    }

    delete[] arr;
    delete[] smallerArr;

    return 0;
}

