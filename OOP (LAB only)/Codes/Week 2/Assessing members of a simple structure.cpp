#include <iostream>
using namespace std;

struct Student //Declaring a Structure
{
	//data members of Structure with Different Data_Types
	int Roll_No;
	string name;
	char grade;
	float avg;
};

main ()
{
	struct Student detail;
	detail.name;
	cin>>detail.name;
	detail.Roll_No=10;
	detail.grade='A';
	detail.avg=12.9;
	cout<<detail.name<<detail.Roll_No<<detail.grade<<detail.avg<<endl;
	
}
