#include <iostream>
using namespace std;

void printArray(int (&arr)[3]) //Not copying the array use orignal array
{
    for(int i = 0; i < 3; i++) 
	{
        cout << arr[i] << " ";
    }
}

int main() {
    int nums[3] = {1, 2, 3};
    printArray(nums);  // Array passed by reference
    return 0;
}

