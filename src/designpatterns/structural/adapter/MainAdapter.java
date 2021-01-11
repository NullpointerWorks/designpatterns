package designpatterns.structural.adapter;

/*
 * Adapter Pattern
 * 
 * The intent of the adapter pattern is to make two different interfaces compatible 
 * by inserting a "middleman" class. The adapter extends/implements the desired 
 * interface and takes an instance of the object to be cast. 
 * 
 * Using adapters usually happens when working with libraries that doesn't have the 
 * abstract needed to implement its features. 
 * 
 * 
 * benefit:
 * - Allows for the use of code that wasn't designed with abstraction in mind.
 * 
 * troubles:
 * - Using this pattern results in more complexity since more classes are necessary 
 *   that don't add functionality to your project.
 */
public class MainAdapter
{

	public static void main(String[] args)
	{
		RoundHole someRoundHole = new RoundHole();
		
		SquarePeg peg = new SquarePeg();
		
		if ( someRoundHole.fits( new Adapter(peg)) )
		{
			System.out.println("it fits!");
		}
		else
		{
			System.out.println("can't circle this square.. or something like that");
		}
		
		
	}

}

/*
 * potential library code you can't change without affecting too many dependencies
 * a class has a parameter that depends on another class in the library
 */
class RoundHole
{
	private double radius = 2.0;
	
	public double getRadius()
	{
		return radius;
	}
	
	public boolean fits(SomethingRound peg)
	{
		return peg.getRadius() <= radius;
	}
}

interface SomethingRound
{
	double getRadius();
}

class RoundPeg implements SomethingRound
{
	private double radius = 2.0;
	
	public double getRadius()
	{
		return radius;
	}
}

/*
 * your custom class that's not compatible with the library
 */
class SquarePeg
{
	private double width = 2.0;
	
	public double getWidth()
	{
		return width;
	}
}

/*
 * the adapter extends the desired library class and takes your implementation as parameter.
 * it then performs all business logic that's required
 */
class Adapter implements SomethingRound
{
	private SquarePeg peg;
	
	public Adapter(SquarePeg p)
	{
		peg = p;
	}
	
	@Override
	public double getRadius()
	{
		return peg.getWidth() * Math.sqrt(2) * 0.5;
	}
}
