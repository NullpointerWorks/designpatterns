#pragma once

typedef const char* cc_string;

class Singleton
{
public: // methods
	static Singleton* getInstance();
	void setMessage(cc_string msg);
	cc_string getMessage() const;

	//Singleton(Singleton& other) = delete; // do not copy
	void operator=(const Singleton&) = delete; // do not assign

private: // fields
	static Singleton* _instance;
	cc_string message;
	Singleton();
	~Singleton();
};

