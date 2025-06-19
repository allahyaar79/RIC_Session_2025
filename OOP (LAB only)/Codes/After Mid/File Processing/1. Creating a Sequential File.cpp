#include <iostream>
#include <fstream>
using namespace std;

int main() {
    ofstream file("data.txt"); // Creating and opening file to write

    file << "Name: Ali\n";     // Writing to file
    file << "Age: 20\n";

    file.close();              // Closing file
    cout << "File created and data written." << endl;
    return 0;
}

