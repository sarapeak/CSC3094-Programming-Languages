#include "Scanner.h"



#include <iostream>
using namespace std;

int main(int argc, char **argv)
{
	if (argc < 2)
	{
		cout << "Usage: <executable name> <filename>";
	}

	Scanner scan(argv[1]);
	
//	cin.ignore();
}


