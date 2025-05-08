#include <iostream>
using namespace std;

class Counter {
public:
    static int count;  // Class variable

    void increase() {
        count++;
    }
};

// Initialize static variable
int Counter::count = 0;

int main() {
    Counter c1, c2;
    c1.increase();
    c2.increase();
    cout << "Count: " << Counter::count << endl;
    return 0;
}

