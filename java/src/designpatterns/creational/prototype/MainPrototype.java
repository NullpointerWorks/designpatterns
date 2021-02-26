package designpatterns.creational.prototype;

/*
 * Prototype Pattern
 * 
 * 
 * 
 */
public class MainPrototype
{

	public static void main(String[] args)
	{
		
		DittoClass ditto1 = new DittoClass("my secret, don't tell anyone");
		
		DittoClass ditto2 = (DittoClass)ditto1.getClone();
		
		System.out.println( ditto2.getMessage() );
		
	}

}

/*
 * the prototype interface with a single method
 */
interface Prototype 
{
	public Prototype getClone();
}

/*
 * a class that implements the prototype
 */
class DittoClass implements Prototype
{
	private String someInfo = "";
	
	public DittoClass(String info)
	{
		someInfo = info;
	}
	
	public String getMessage() 
	{
		return someInfo;
	}

	@Override
	public Prototype getClone() 
	{
		return new DittoClass(someInfo);
	}
}
