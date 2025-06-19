#include <iostream>
#include <fstream>
using namespace std;

int main() {
    fstream file("random.txt", ios::out | ios::in | ios::trunc);
    file << "ABCDEFGH";  // Write some text

    file.seekp(3);       // Move write pointer to position 3 (0-indexed)
    file << "X";         // Replace 4th character (D) with X

    file.seekg(0);       // Move read pointer to beginning

    char ch;
    cout << "Updated file content: ";
    while (file.get(ch)) {
        cout << ch;
    }

    file.close();
    return 0;
}

