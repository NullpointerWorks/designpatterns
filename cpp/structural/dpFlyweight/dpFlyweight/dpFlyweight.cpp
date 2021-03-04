#include <iostream>
#include <string>
#include <map>

using std::cout;
using std::endl;
using std::string;
using std::map;
using std::pair;

/*
    define a resource to be reused
*/
class Integer
{

};

/*
    the flyweight class acts as a storage sustem to return existing resources
*/
class Flyweight
{
private:
    map<int, Integer*> int_map;

public:
    Flyweight()
    {

    }
    ~Flyweight()
    {
        for (auto entry : int_map)
        {
            delete entry.second;
        }
    }

    Integer* getInteger(int i)
    {
        auto it = int_map.find(i);
        if (it != int_map.end())
        {
            cout << "returning existing resource\n";

            return it->second;
        }
        else
        {
            cout << "allocating new resource\n";

            Integer* inst = new Integer();
            int_map[i] = inst;
            return inst;
        }
    }
};

int main()
{
    Flyweight flyweight;

    int myList[17] = {4,1,7,6,2,7,0,3,6,4,2,7,9,5,8,0,3};
    Integer* myIntList[17];

    int i = 0;
    int l = 17;
    for (; i<l ;i++)
    {
        myIntList[i] = flyweight.getInteger( myList[i] );
    }

}
