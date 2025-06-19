#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
    string line;

    // Reading from file
    ifstream file("data.txt");
    cout << "Reading from file:\n";
    while (getline(file, line)) {
        cout << line << endl;
    }
    file.close();

    // updating new data
    ofstream fileUpdate("data.txt", ios::app); // 'app' means append
    fileUpdate << "City: Lahore\n";
    fileUpdate.close();

    cout << "\nNew data appended to file.\n";
    return 0;
}

