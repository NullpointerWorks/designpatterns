#include <iostream>
#include <string>
#include <list>

using std::cout;
using std::endl;
using std::string;
using std::list;

// resource interface. in this example uses a database
class IDatabase
{
public:
	virtual ~IDatabase() {}
	virtual string query(string request) = 0;
};

// mock database
class Database : public IDatabase
{
private:

public:
	Database() {}
	~Database() {}

	string query(string request) override
	{
		cout << "do expensive database call: " << request << endl;
		return "Hello World!";
	}
};

// this proxy caches results so to minimize the calls to the database
class CacheProxy : public IDatabase
{
private:
	IDatabase* base;
	string request;
	string cache;

public:
	CacheProxy(IDatabase* db)
	{
		base = db;
		request = "";
		cache = "";
	}

	string query(string q) override
	{
		if (request.compare(q)==0)
		{
			cout << "return cached result set" << endl;
			return cache;
		}

		request = q;
		cache = base->query(q);
		return cache;
	}
};

// try it out
int main()
{
	Database db;
	cout << "make direct database calls. very resource intensive\n";
	db.query("select * from users");
	db.query("select * from users");
	db.query("select * from users");

	cout << "\n";

	CacheProxy cacheProxy(&db);
	cout << "use a caching proxy. saves computation power\n";
	cacheProxy.query("select * from users");
	cacheProxy.query("select * from users");
	cacheProxy.query("select * from users");

	/*
		proxies can be good for all sorts of things;
		- a cache proxy, as demonstrated by this example
		- thread-safe proxy
		- verification proxy
		- logging proxy
		- stacktrace/debug proxy
		- limiting buffer proxy
		- etc.

		as an added bonus, you dont have to make a large all-encompassing 
		proxy to combine funcitonality. that all share the same interface 
		and can therefor be chained together. this seperates responsibility
		in your code and make it better maintainable.

		this pattern shares some resemblance to the decorator pattern
	*/

	return 0;
}
