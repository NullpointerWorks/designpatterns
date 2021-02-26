// dpSingleton.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Singleton.h"

using namespace std;

int main()
{
    
    Singleton* single1 = Singleton::getInstance();
    single1->setMessage("Hello World!");

    Singleton* single2 = Singleton::getInstance();
    cout << single2->getMessage() << endl;

}

