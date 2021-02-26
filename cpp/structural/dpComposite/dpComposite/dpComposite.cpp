#include <iostream>
#include <string>
#include <list>

using std::cout;
using std::endl;
using std::string;
using std::list;

/*
	
*/
class Component
{
public:
	virtual ~Component() {}
	virtual int execute() = 0;
};

/*
	
*/
class Node: public Component
{
private:
	list<Component*> children;

public:
	Node() {}
	~Node() override {}

	void addComponent(Component* comp)
	{
		children.push_back(comp);
	}

	void removeComponent(Component* comp)
	{
		children.remove(comp);
	}

	int execute() override
	{
		int sum = 0;
		for (Component* c : children)
		{
			sum += c->execute();
		}
		return sum;
	}
};

/*
	
*/
class Leaf: public Component
{

public:
	Leaf() {}
	~Leaf() override {}

	int execute() override
	{
		return 1;
	}
};



int main()
{


	Node base;
	Leaf leaf1;
	Leaf leaf2;
	Leaf leaf3;
	base.addComponent(&leaf1);
	base.addComponent(&leaf2);
	base.addComponent(&leaf3);

	Node trunk1;
	Leaf leaf4;
	Leaf leaf5;
	trunk1.addComponent(&leaf4);
	trunk1.addComponent(&leaf5);

	base.addComponent(&trunk1);

	int sum = trunk1.execute();
	cout << "the trunk has " << sum << " leafs\n";

	sum = base.execute();
	cout << "the base has " << sum << " leafs\n";
}
