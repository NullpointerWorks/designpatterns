package designpatterns.creational.singleton;

/*
 * The singleton pattern's purpose is to ensure a single global point 
 * of access to a class's logic. It is a simple trick that gives a 
 * lot of power in your application. Use it only when it makes sense.
 * 
 * In Object-Oriented Programming this pattern is generally frowned 
 * upon because it breaks the programming paradigm. If it's abused,
 * the project quickly becomes a spaghetti of references and might 
 * become prone to concurrency issues.
 * 
 * Having that said, singletons do have a place in application 
 * programming that would be considered acceptable. The primary use 
 * of a singleton is when information is a one-way street. The best 
 * example is a data logger. Information goes in and has no impact on 
 * the application's logic. Another purpose is to prevent wasting 
 * resources when needing common functionality, like utility classes.
 * 
 * benefit:
 * - A single global point of access can be used anywhere in your 
 *   project.
 * - Can be lazy loaded, thus not using space, until it's needed
 * - Any class can be sub-classed into a singleton.
 * 
 * troubles:
 * - When singletons perform application logic, one area of your app
 *   may not know about changes another area of the app is trying to 
 *   apply.
 * - Tracing bugs related to singleton I/O logic can be difficult to 
 *   fix. Specially when your project is getting large.
 * - Lost instance references may cause the singleton not to be garbage 
 *   collected properly, wasting resources
 * - Lazy loaded singletons will always perform a conditional check 
 *   before returning the instance.
 * 
 */
public class MainSingleton
{

	public static void main(String[] args)
	{
		
		EarlySingleton.getInstance();
		LazySingleton.getInstance();
		
		
	}

}

/*
 * a.k.a. asynchronous loading
 */
class LazySingleton
{
	private static LazySingleton inst = null;
	public static LazySingleton getInstance()
	{
		if (inst==null) inst=new LazySingleton();
		return inst;
	}
	
	private LazySingleton()
	{
		System.out.println("lazy loaded");
	}
	
	
}

/*
 * a.k.a eager loading
 */
class EarlySingleton
{
	private static EarlySingleton inst = new EarlySingleton();
	public static EarlySingleton getInstance()
	{
		return inst;
	}
	
	private EarlySingleton()
	{
		System.out.println("early loaded");
	}
	
}
