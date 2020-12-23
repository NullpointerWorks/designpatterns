package designpatterns.creational.dependencyinjection;

/*
 * Dependency Injection Pattern
 * 
 * 
 * 
 */
public class MainDependencyInjection
{
	public static void main(String[] args) 
	{
		
	}
}

/*
 * Define a  mock dependencies. 
 */
class Dependancy
{
	// does nothing, cuz it doesn't have to
}

/*
 * observe this following class
 */
class NotInjectedClass
{
	private Dependancy dep;
	
	public NotInjectedClass()
	{
		dep = new Dependancy();
		
	}
}

/*
 * using a constructor
 */
class InjectedClass1
{
	private Dependancy dep;
	
	public InjectedClass1(Dependancy dep)
	{
		this.dep = dep;
		
	}
}

/*
 * using a setter
 */
class InjectedClass2
{
	private Dependancy dep;
	
	void setDependancy(Dependancy dep)
	{
		this.dep = dep;
	}
}

/*
 * or using an interface to make the injection abstract
 */
interface InjectionInterface
{
	void setDependancy(Dependancy dep);
}

class InjectedClass3 implements InjectionInterface
{
	private Dependancy dep;
	
	@Override
	public void setDependancy(Dependancy dep) 
	{
		this.dep = dep;
	}
}
