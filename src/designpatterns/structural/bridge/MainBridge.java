package designpatterns.structural.bridge;

/*
 * Bridge Pattern
 * 
 * This pattern is a simple, straight-forward solution to a potentially terrible 
 * problem. 
 * 
 * Imagine having a class that might have a lot of attributes. Or may be getting a 
 * lot more during the project's development. 
 * 
 * You made a "vehicle" interface to make different modes of transportation abstract.
 * Good call, but as your application becomes more complex, the need to distinguish 
 * different attributes about the vehicle become important.
 * 
 * What do you do;
 * - make a lot of classes each unique in an attribute? 
 * - or make a field for each attribute to be filled on creation.
 * 
 * If you take the path of the first option, you get exponential increase of classes 
 * and duplicate code. This is to be avoided.
 * 
 * The second option is the obvious solution. Just turn the attributes into fields.
 * And that's the "bridge pattern". It's so simple and obvious even programmers who 
 * don't know about this pattern implement it. This is why it has become a design 
 * pattern. A common solution to a potentially big problem.
 * 
 * benefit:
 * - saves a lot of copy-pasta
 * - makes attribute expansion simple and manageable
 * 
 * troubles:
 * - each attribute needs a new interface and implementing classes, but the sum of new 
 *   classes/interfaces are a far-cry from exponential growth of your code base.
 * 
 */
public class MainBridge
{

	public static void main(String[] args)
	{
		/*
		 * without bridge
		 */
		SuperGreenCar sgc = new SuperGreenCar();
		
		System.out.println(sgc.getColor() + " " + sgc.getType());
		
		/*
		 * with bridge
		 */
		Color supergreen = new SuperGreen();
		GenericCar gc = new GenericCar(supergreen);
		
		System.out.println(gc.getColor() + " " + gc.getType());
	}

}

/*
 * observe the interface and implementation below.
 * the classes below have the color and type hardcoded in the implementation.
 */
interface Vehicle
{
	String getType();
	String getColor();
}

class SuperGreenCar implements Vehicle
{
	public String getType()
	{
		return "Car";
	}
	
	public String getColor()
	{
		return "Super Green";
	}
}

class RedCar implements Vehicle
{
	public String getType()
	{
		return "Car";
	}
	
	public String getColor()
	{
		return "Red";
	}
}

class BrownWagon implements Vehicle
{
	public String getType()
	{
		return "Wagon";
	}
	
	public String getColor()
	{
		return "Brown";
	}
}

class GoldenWagon implements Vehicle
{
	public String getType()
	{
		return "Wagon";
	}
	
	public String getColor()
	{
		return "Gold";
	}
}

/*
 * the solution is the bridge pattern.
 * Use the bridge pattern to save exponential increase of classes
 */
interface Color
{
	String getColor();
}

class SuperGreen implements Color
{
	public String getColor()
	{
		return "Super Green";
	}
}

class Brown implements Color
{
	public String getColor()
	{
		return "Brown";
	}
}

/*
 * new classes that demonstrate the application of a bridge with a color attribute.
 * it's nothing more than making a field to store the additional data.
 * 
 * You could take this approach ever further. The fact the vehicles could be a car 
 * or wagon could be made an attribute as well. leaving a generic vehicle class that 
 * can be expanded upon.
 * 
 * You could deploy a builder pattern to control the final product
 */
class GenericCar implements Vehicle
{
	private Color myColor;
	
	public GenericCar(Color color)
	{
		myColor = color;
	}
	
	public String getType()
	{
		return "Car";
	}
	
	public String getColor()
	{
		return myColor.getColor();
	}
}

class GenericWagon implements Vehicle
{
	private Color myColor;
	
	public GenericWagon(Color color)
	{
		myColor = color;
	}
	
	public String getType()
	{
		return "Wagon";
	}
	
	public String getColor()
	{
		return myColor.getColor();
	}
}
