package designpatterns.creational.singleton;

/*
 * Singleton Pattern
 * 
 * The singleton pattern's purpose is to ensure a single global point 
 * of access to a class's logic. It is a simple trick that gives a 
 * lot of power in your application. Use it only when it makes sense.
 * 
 * In Object-Oriented Programming this pattern is generally frowned 
 * upon because it breaks the programming paradigm. If it's abused,
 * the project quickly becomes a spaghetti of references and might 
 * become prone to concurrency issues and confusion.
 * 
 * Having that said, singletons do have a place in application 
 * programming that might be considered acceptable. The primary use 
 * for a singleton is when information is a one-way street.
 * - The best example is a data logger. Information goes into the logger 
 *   and gets dumped somewhere. Booting the application with the logger 
 *   disabled will not impact the internal logic. 
 * - Another purpose for singletons is to prevent wasting resources 
 *   when needing common functionality like utility classes. 
 * - Sometimes instantiating new objects might be a costly operation 
 *   where singletons act as an optimization strategy. However this 
 *   can also be accomplished with the monostate- or the prototype 
 *   pattern.
 * 
 * benefit:
 * - A single global point of access can be used anywhere in your 
 *   project. You get it's power whenever you need it at any place, 
 *   any time.
 * - Can be lazy loaded, thus not using space, until it's needed.
 * - Any class can be sub-classed into a singleton.
 * 
 * troubles:
 * - it's a direct violation of the "single responsibility" principle!
 * - When singletons perform application logic, one area of your app
 *   may not know about changes another area of the app is trying to 
 *   apply.
 * - Tracing bugs related to singleton I/O logic can be difficult to 
 *   fix. Specially when your project is getting large.
 * - Lost instance references may cause the singleton not to be garbage 
 *   collected properly, wasting resources.
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
