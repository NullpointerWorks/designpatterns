package designpatterns.behavioral.monostate;

/**
 * @see singleton pattern
 * 
 * Monostate pattern
 * 
 * 
 * This pattern has a close relationship to the singleton pattern. It's a way to share 
 * information through globally accessible information, however taking different 
 * approaches. The singleton enforces a single instance of a object. All information 
 * stored in the singleton can only be accessed by calling a getInstance() method. 
 * The monostate pattern hides information within it's private global state. The only 
 * way to access this information is to instantiate a new object and call the 
 * appropriate methods.
 * 
 * Both patterns effectively provide global information, but accessing the information
 * differs. While singletons cannot be subclassed, monostates can. Any class can be 
 * made a singleton, not so for monostates. Both approaches give a lot of power to the 
 * user and need to be used with care, if needed at all. 
 * 
 * benefit:
 * - data calls are done through dynamic methods. They can be overridden. In other words
 *   this pattern is polymorphic.
 * - the monostate's life cycle depends on the calling thread. the monostate data 
 *   remains until the application is closed.
 * 
 * troubles:
 * - just like the singleton this approach breaks the OOP paradigm, but in a more 
 *   subtle way. It seems like a normal object, but under the hood it uses shared data.
 * - data I/O needs to be thread-safe with concurrency checks.
 * 
 */
public class MainMonostate
{
	public static void main(String[] args)
	{
		
		Monostate m1 = new Monostate();
		Monostate m2 = new Monostate();
		
		m1.setState("my data");
		
		System.out.println( m2.getState() );
		
		MonostateDerived m3 = new MonostateDerived();
		System.out.println( m3.getState() );
		
	}
}

/*
 * class with the monostate information
 */
class Monostate
{
	private static String monoStateData = "";

	public void setState(String state)
	{
		monoStateData = state;
	}
	
	public String getState()
	{
		return monoStateData;
	}
	
    public Monostate()
    {
    	
    }
}

/*
 * monostate sub-class
 */
class MonostateDerived extends Monostate
{
	public String getState()
	{
		return "derived: " + super.getState();
	}
}
