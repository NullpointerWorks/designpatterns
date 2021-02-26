#include <iostream>
#include <string>
#include <map>

using std::cout;
using std::endl;
using std::string;
using std::map;

class Multiton
{
private:
    static map<int, Multiton*> m;
    string message;

    Multiton()
    {
        message = "";
    }

    ~Multiton() {}

public:
    void operator=(const Multiton&) = delete;

    static Multiton* getInstance(int key)
    {
        auto it = m.find(key);
        if ( it != m.end() )
        {
            return it->second;
        }
        else
        {
            Multiton* multi = new Multiton();
            m[key] = multi;
            return multi;
        }
    }

    void setMessage(string msg)
    {
        message = msg;
    }

    string getMessage()
    {
        return message;
    }
};

map<int, Multiton*> Multiton::m; // static init

int main()
{

    Multiton* mult1 = Multiton::getInstance(0);
    Multiton* mult2 = Multiton::getInstance(1);

    mult1->setMessage("Hello!");
    mult2->setMessage("World!");

    cout << mult1->getMessage() << endl;
    cout << mult2->getMessage() << endl;

    mult2 = Multiton::getInstance(0); // fill mult2 with another instance
    cout << mult2->getMessage() << endl;
}
