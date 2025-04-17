#include <iostream>
#include <cstring>
using namespace std;

int main() {
    char text[] = "Hello, welcome to class!";
    char word[] = "welcome";

    if (strstr(text, word)) {
        cout << "Substring found!" << endl;
    } else {
        cout << "Substring not found." << endl;
    }

    return 0;
}

