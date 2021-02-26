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
		/*
		 * make some clients to represent connections
		 */
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		
		/*
		 * make a server using the proxy
		 */
		IServer service = new ProxyServer( new Server() );
		//IServer service = new ChacheProxyServer( new Server() );
		
		/*
		 * do operations
		 */
		service.sendQuery( client1.getQuery() );
		service.sendQuery( client2.getQuery() );
		service.sendQuery( client3.getQuery() );
	}
}

/*
 * make a server object that communicates with a database. this object would be a heavy-weight
 * have the server implement an server interface
 */
class Server implements IServer
{
	public String[] sendQuery(String sql)
	{
		// do costly database operation
		System.out.println( sql );
		// return a dataset of users
		return new String[] {"Peter", "James", "Cathy", "Anne"};
	}
}

interface IServer
{
	String[] sendQuery(String sql);
}

/*
 * have a class represent a client that interacts with the database
 */
class Client
{
	public String getQuery()
	{
		return "SELECT * FROM USERS";
	}
}

/*
 * now for our proxy.
 * it takes a service as constructor parameter
 * the class implements the same interface as the service.
 * implemented methods just delegate this to the given service.
 * 
 */
class ProxyServer implements IServer
{
	private IServer service;
	
	public ProxyServer(IServer s)
	{
		service = s;
	}
	
	public String[] sendQuery(String sql)
	{
		return service.sendQuery(sql);
	}
}

/*
 * adding as an example, 
 */
class ChacheProxyServer implements IServer
{
	private java.util.Map<String,String[]> cache;
	private IServer service;
	
	public ChacheProxyServer(IServer s)
	{
		cache = new java.util.HashMap<String,String[]>();
		service = s;
	}
	
	public String[] sendQuery(String sql)
	{
		String[] dataset;
		if (cache.containsKey(sql))
		{
			dataset = cache.get(sql);
		}
		else
		{
			dataset = service.sendQuery(sql);
			cache.put(sql, dataset);
		}
		return dataset;
	}
}
