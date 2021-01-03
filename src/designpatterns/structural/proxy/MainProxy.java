package designpatterns.structural.proxy;

/*
 * Proxy Pattern
 * 
 * 
 * 
 */
public class MainProxy
{
	public static void main(String[] args) 
	{
		
		
	}
}

/*
 * make a server object that communicates with a database. this object would be a heavy-weight
 * have the server implement an server interface
 */
class Server implements IServer
{
	public void sendQuery(String sql)
	{
		// do costly database operation
	}
}

interface IServer
{
	void sendQuery(String sql);
}

/*
 * have a class represent a client that interacts with the database
 */
class Client
{
	
	
}

/*
 * now for our proxy.
 * 
 * 
 */
class ProxyServer implements IServer
{
	private IServer service;
	
	public ProxyServer(IServer s)
	{
		service = s;
	}
	
	public void sendQuery(String sql)
	{
		service.sendQuery(sql);
	}
}
