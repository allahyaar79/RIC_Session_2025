#include <iostream>
using namespace std;

int main() {
    int arr[3] = {5, 10, 15};

    cout << "Values and Addresses:\n";
    for(int i = 0; i < 3; i++) {
        cout << "Value: " << *(arr + i);
        cout << ", Address: " << (arr + i) << endl;
    }

    return 0;
}


