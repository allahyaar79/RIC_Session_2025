#include <iostream>
using namespace std;

int main() {
    char letters[5] = {'\0'}; // NULL for character array

    for (int i = 0; i < 5; i++) {
        if (letters[i] == '\0')
            cout << "NULL ";
        else
            cout << letters[i] << " ";
    }

    return 0;
}

