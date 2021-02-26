package designpatterns.structural.decorator;

/*
 * Decorator Pattern
 * 
 * Decorators are used to add functionality to a method the base instance doesn't 
 * contain. It's a lot like a recursive method that calls itself acting like a loop.
 * Except this loop is limited to number of instances nested together.
 * 
 * benefit:
 * - this pattern makes it easy to separate responsibility to different classes
 * - the behavior can be easily expanded without altering the base code.
 * 
 * troubles:
 * - the execution chain is construction sensitive. It's hard to alter the chain
 * - 
 * 
 */
public class MainDecorator
{
	public static void main(String[] args)
	{
		
		Pizza newPizza = new PizzaBottom();
		
		newPizza = new TomatoSauce(newPizza);
		
		newPizza = new Veggies(newPizza);
		
		newPizza = new Mozarella(newPizza);
		
		System.out.println( newPizza.getDescription() );
		
	}
}

/*
 * decorator interface. nothing special
 */
interface Pizza
{
	String getDescription();
}

/*
 * this design consists of two types of implementations.
 * there are classes that take another decorator as a base, and
 * a final decorator that ends the execution chain. you could 
 * decide to use an empty constructor and a null check instead.
 */
class PizzaBottom implements Pizza
{
	@Override
	public String getDescription() 
	{
		return "crunchy bottom";
	}
}

class TomatoSauce implements Pizza
{
	private Pizza base = null;
	
	public TomatoSauce(Pizza b)
	{
		base = b;
	}
	
	@Override
	public String getDescription() 
	{
		return base.getDescription() + " with tomato sause";
	}
}

class Veggies implements Pizza
{
	private Pizza base = null;
	
	public Veggies(Pizza b)
	{
		base = b;
	}
	
	@Override
	public String getDescription() 
	{
		return base.getDescription() + " and vegetables";
	}
}

class Mozarella implements Pizza
{
	private Pizza base = null;
	
	public Mozarella(Pizza b)
	{
		base = b;
	}
	
	@Override
	public String getDescription() 
	{
		return base.getDescription() + " topped with some mozarella";
	}
}
