#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

/*
    builder interface with construction steps
*/
class Builder
{
public:
    virtual ~Builder() {} 
    virtual void reset() = 0;
    virtual void doStepA() = 0;
    virtual void doStepB() = 0;
};

/*
    define some options for building
*/
enum class BuildOption
{
    SIMPLE,
    ADVANCED
};

/*
    define a director that executes builder methods
*/
class Director
{
public:
    void build(Builder* builder, BuildOption option)
    {
        builder->reset();
        switch (option)
        {
        case BuildOption::SIMPLE:
            builder->doStepA();
            break;

        case BuildOption::ADVANCED:
            builder->doStepA();
            builder->doStepB();
            break;
        }
    }
};

/*
    define an item to be created and a builder class to create it
*/
class Concrete
{
private:
    string mixture;
    string enforced;

public:
    Concrete(string m, string e)
    {
        mixture = m;
        enforced = e;
    }

    void print()
    {
        cout << enforced << " " << mixture << endl;
    }
};

class ConcreteBuilder : public Builder
{
private:
    string mixture;
    string enforced;

public:
    ConcreteBuilder()
    {
        reset();
    }

    ~ConcreteBuilder() override {}

    void reset() override
    {
        mixture = "";
        enforced = "solid";
    }

    void doStepA() override
    {
        mixture = "concrete";
    }

    void doStepB() override
    {
        enforced = "steel mesh";
    }

    Concrete* getResult()
    {
        return new Concrete(mixture, enforced);
    }
};

/*
    lets test it out
*/
int main()
{
    ConcreteBuilder* inst = new ConcreteBuilder();

    Director director;
    director.build(inst, BuildOption::ADVANCED );

    Concrete* concrete = inst->getResult();
    concrete->print();

    delete concrete;
    delete inst;
}
