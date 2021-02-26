package designpatterns.creational.multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * @see Singleton Pattern
 * 
 * Multiton Pattern
 * 
 * 
 * 
 * 
 */
public class MainMultiton
{

	public static void main(String[] args)
	{
		Multiton inst1 = Multiton.getInstance(0);
		Multiton inst2 = Multiton.getInstance(1);
		inst2.setMessage("This is another instance!");
		
		System.out.println( inst1.getMessage() );
		System.out.println( inst2.getMessage() );
		
		inst2 = Multiton.getInstance(0);
		System.out.println( inst2.getMessage() );
	}
}

class Multiton
{
	private static Map<Integer, Multiton> map = new HashMap<Integer, Multiton>();
	public static Multiton getInstance(int key)
	{
		Multiton inst;
		if (!map.containsKey(key))
		{
			inst = new Multiton();
			map.put(key, inst);
		}
		else
		{
			inst = map.get(key);
		}
		return inst;
	}
	
	private String msg = "Hello World!";
	private Multiton() {}
	
	public String getMessage()
	{
		return msg;
	}
	
	public void setMessage(String m)
	{
		msg = m;
	}
}
