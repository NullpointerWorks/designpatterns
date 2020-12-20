package designpatterns.creational.abstractfactory;

/**
 * @see factory method pattern
 * 
 * Abstract Factory Pattern
 * 
 * The abstract factory is an extension of the regular factory method pattern. 
 * Instead of creating a single type of object, it's now responsible for 
 * creating a family of related objects(two or more).
 * 
 * A "factory method pattern" implementation that returns multiple sorts of 
 * objects but are not in any way related(aside from Java's "Object") does not 
 * count as an abstract factory.
 * 
 * benefit:
 * - prevents showing concrete implementing classes, like factories should
 * - ensures all created objects share a root interface (a family of objects)
 *   including a consistent set of base methods
 * 
 * troubles:
 * - you don't always know what kind of object hides behind the interface. 
 *   casting these objects might become a problem.
 * 
 */
public class MainAbstractFactory
{
	public static void main(String[] args)
	{
		
		ItemFactory ifactory = new GoodItemFactory();
		
		Item item = ifactory.getNewIngredient();
		
		System.out.println( item.getName() );
		
	}
}

/*
 * create a root interfaces that demonstrate the relationship between all objects the factory can produce.
 */
interface Item
{
	String getName();
}

/*
 * make interfaces that implement the root interface
 */
interface Material extends Item
{
	String isValuable();
}

interface Ingredient extends Item
{
	String isAnyGood();
}

/*
 * make implementing classes. this example shows two factories that make good and bad items
 */
class BadMaterial implements Material
{
	@Override
	public String isValuable()
	{
		return "dirt..";
	}

	@Override
	public String getName()
	{
		return "bad material";
	}
}

class GoodMaterial implements Material
{
	@Override
	public String isValuable()
	{
		return "ggoooolllddd!!!";
	}

	@Override
	public String getName()
	{
		return "good material";
	}
}

class BadIngredient implements Ingredient
{
	@Override
	public String isAnyGood()
	{
		return "definetely rotten";
	}

	@Override
	public String getName()
	{
		return "bad ingredient";
	}
}

class GoodIngredient implements Ingredient
{
	@Override
	public String isAnyGood()
	{
		return "fresh and peachy";
	}

	@Override
	public String getName()
	{
		return "good ingredient";
	}
}

/*
 * make a factory interface returning the two related interfaces.
 */
interface ItemFactory
{
	Material getNewMaterial();
	Ingredient getNewIngredient();
}

/*
 * make two implementing factory classes
 */
class BadItemFactory implements ItemFactory
{
	@Override
	public Material getNewMaterial()
	{
		return new BadMaterial();
	}

	@Override
	public Ingredient getNewIngredient()
	{
		return new BadIngredient();
	}
}

class GoodItemFactory implements ItemFactory
{
	@Override
	public Material getNewMaterial()
	{
		return new GoodMaterial();
	}

	@Override
	public Ingredient getNewIngredient()
	{
		return new GoodIngredient();
	}
}

