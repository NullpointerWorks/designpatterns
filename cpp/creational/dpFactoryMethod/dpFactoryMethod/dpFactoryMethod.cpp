#include <iostream>

/*
	Some item to create
*/
class Item
{
public:
	void doHello()
	{
		std::cout << "Hello!" << std::endl;
	}
};

/*
	Factory interface
*/
class IFactory
{
public:
	virtual Item* getItem() = 0;
};

/*
	The factory implementation
*/
class Factory : public IFactory
{
public:
	Item* getItem() override
	{
		return new Item();
	}
};

int main()
{
	IFactory* factory = new Factory();

	Item* item1 = factory->getItem();
	item1->doHello();

	delete item1;
	delete factory;
}
