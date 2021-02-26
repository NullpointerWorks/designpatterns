#include "Singleton.h"

#define NULL 0

Singleton* Singleton::_instance = nullptr;

Singleton::Singleton()
{
	message = NULL;
}

Singleton::~Singleton()
{
	delete _instance;
}

Singleton* Singleton::getInstance()
{
	if (_instance == nullptr)
		_instance = new Singleton();
	return _instance;
}

void Singleton::setMessage(cc_string msg)
{
	message = msg;
}

cc_string Singleton::getMessage() const
{
	return message;
}
