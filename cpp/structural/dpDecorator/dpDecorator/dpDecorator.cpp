#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

// decoration interface
class Decoration
{
public:
    virtual ~Decoration() {}
    virtual string getDescription() = 0;
};

// this decorator class represent the first element in the decoration chain
// it has no parent
class PizzaBottom: public Decoration
{
public:
    PizzaBottom() {}

    string getDescription() override
    {
        return "a baked crispy dough bottom";
    }

};

// some sauce for your pizza
class TomatoSause : public Decoration
{
private:
    Decoration* parent;

public:
    TomatoSause(Decoration* p) 
    {
        parent = p;
    }

    string getDescription() override
    {
        return "soft tomato sause on " + parent->getDescription();
    }

};

// gotta love me some bellpepper yo
class BellPepperTopping : public Decoration
{
private:
    Decoration* parent;

public:
    BellPepperTopping(Decoration* p)
    {
        parent = p;
    }

    string getDescription() override
    {
        return "bellpepper slices sprinkled on top of " + parent->getDescription();
    }
};

// chain the decorator together starting with the bottom
int main()
{
    PizzaBottom bottom;
    TomatoSause sause(&bottom);
    BellPepperTopping veggies(&sause);
    
    cout << veggies.getDescription() << endl;
}
