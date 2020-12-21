package designpatterns.structural.adapter;

/*
 * Adapter Pattern
 * 
 * 
 * 
 * benefit:
 * 
 * troubles:
 */
public class MainAdapter
{

	public static void main(String[] args)
	{
		
		RoundHole someRoundHole = new RoundHole();
		
		SquarePeg peg = new SquarePeg();
		
		if ( someRoundHole.fits(new Adapter(peg)) )
		{
			System.out.println("it fits!");
		}
		else
		{
			System.out.println("can't square this round.. or something like that");
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
	
	public boolean fits(RoundPeg peg)
	{
		return peg.getRadius() <= radius;
	}
}

class RoundPeg
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
class Adapter extends RoundPeg
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
