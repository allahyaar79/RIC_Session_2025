#include <iostream>
using namespace std;

struct Student
{
	int Roll_No;
	string name;
	char grade;
	float avg;
};

main ()
{
	struct Student detail;
	detail.Roll_No=10;
	cout<<detail.Roll_No;
	cout<<endl;
	detail.name="Ali";
	cout<<detail.name;
}
