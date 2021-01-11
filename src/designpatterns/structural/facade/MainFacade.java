package designpatterns.structural.facade;

/*
 * Facade Pattern
 * 
 * This pattern is rather straightforward. Even programmers who don't know this 
 * pattern have still unknowingly implemented it in their projects. 
 * 
 */
public class MainFacade 
{
	public static void main(String[] args) 
	{
		
		ConnectionFacade facade = new ConnectionFacade();
		
		System.out.println( facade.getFile("amazing!") );
		
	}
}

/*
 * 
 */
class ConnectionFacade
{
	private Connection dbconn = new DatabaseConnection();
	
	public String getFile(String identification)
	{
		String file = "error fetching your file";
		
		dbconn.connect("\\mydatabase");
		
		if (dbconn.hasFile(identification))
		{
			file = dbconn.fetch(identification);
		}
		
		dbconn.disconnect();
		
		return file;
	}
}

/*
 * 
 */
interface Connection
{
	void connect(String url);
	
	void disconnect();
	
	String fetch(String identification);
	
	boolean hasFile(String identification);
}

class DatabaseConnection implements Connection
{
	
	@Override
	public void connect(String url) 
	{
		// this would be database connection code. usually a costly operation
	}

	@Override
	public void disconnect() 
	{
		// disconnecting after you're done is the polite thing to do,.. and prevents memory leaks that explode your system
	}

	@Override
	public String fetch(String identification) 
	{
		return hasFile(identification)?"amazing file you want to see!":"404: file not found";
	}
	
	@Override
	public boolean hasFile(String identification)
	{
		return identification.equalsIgnoreCase("amazing!");
	}
}
