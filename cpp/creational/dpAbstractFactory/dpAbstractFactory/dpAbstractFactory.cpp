#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

/*
	Some items to create
*/
class Food
{
private:
	string name;

public:
	Food(string n)
	{
		name = n;
	}

	string getName()
	{
		return name;
	}
};

class Drink
{
private:
	string name;

public:
	Drink(string n)
	{
		name = n;
	}

	string getName()
	{
		return name;
	}
};



/*
	Abstract Factory
*/
class IAbstractFactory
{
public:
	virtual Food* getFood(string) = 0;
	virtual Drink* getDrink(string) = 0;
};

/*
	The factory implementation
*/
class AbstractFactory : public IAbstractFactory
{
public:
	Food* getFood(string name)
	{
		return new Food(name);
	}

	Drink* getDrink(string name)
	{
		return new Drink(name);
	}
};

int main()
{
	IAbstractFactory* afactory = new AbstractFactory();

	Food* item1 = afactory->getFood("Pizza");
	cout << item1->getName() << endl;

	Drink* item2 = afactory->getDrink("Cream Soda");
	cout << item2->getName() << endl;


	delete item2;
	delete item1;
	delete afactory;
}
