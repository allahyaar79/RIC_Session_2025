#include <iostream>
using namespace std;

int main() {
    int size;//size is a variable you may used as per your convenience

    // User se array size lena
    cout << "Enter the size of the array: ";
    cin >> size;

    // Dynamic memory allocation using pointer
    int* ptr = new int[size];//datatype* nameOfPointerVariable = new datatype[sizeVariableOfYourArray]

    // Array ke elements input karna
    cout << "Enter " << size << " elements: " << endl;
    for (int i = 0; i < size; i++) {
        cin >> ptr[i];  // Pointer ke zariye values input karna
    }

    // Array ke elements ko display karna
    cout << "The elements in the array are: " << endl;
    for (int i = 0; i < size; i++) {
        cout << ptr[i] << endl;
    }

    // Dynamic memory ko free karna
    delete[] ptr;

    return 0;
}

