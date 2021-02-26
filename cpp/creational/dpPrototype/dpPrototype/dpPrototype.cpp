#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::string;

/*
    the prototype interface provides a duplication method
*/
class Prototype
{
public:
    virtual Prototype* clone() = 0;
};

/*
    the prototype method uses a private contructor to copy over all public and private data
*/
class Ditto : public Prototype
{
private:
    string message;

    Ditto(string msg)
    {
        setMessage(msg);
    }

public:
    Ditto() 
    {
        setMessage("");
    }

    void setMessage(string msg)
    {
        message = msg;
    }

    string getMessage()
    {
        return message;
    }

    Prototype* clone() override
    {
        return new Ditto( getMessage() );
    }
};

/*
    make a ditto class with a secret message.
    duplicate the ditto and ask the clone what the message was.
    cleanup the ditto's for good practice' sake
*/
int main()
{
    Ditto* ditto1 = new Ditto();
    ditto1->setMessage( "My super secret message. Don't tell anyone!" );

    Ditto* ditto2 = (Ditto*)ditto1->clone();
    cout << ditto2->getMessage() << endl;

    delete ditto1;
    delete ditto2;
}
