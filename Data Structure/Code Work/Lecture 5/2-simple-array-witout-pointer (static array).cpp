#include <iostream>
using namespace std;

int main() {
    int numbers[5] = {10, 20, 30, 40, 50};  // static array with 5 elements

    // Array elements ko display karna
    cout << "Show Array values without loop" << endl;
//    cout << numbers[0];
    cout << "Array elements are: " << endl;
    
	
	for (int i = 0; i < 5; i++)
	
	
	 {
        cout << numbers[i] << endl;
           
    }

 return 0;
}

