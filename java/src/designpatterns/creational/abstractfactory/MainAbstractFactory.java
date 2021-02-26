package designpatterns.creational.abstractfactory;

/**
 * @see factory method pattern
 * 
 * Abstract Factory Pattern
 * 
 * The abstract factory is an extension of the regular factory method pattern. 
 * Instead of being responsible for creating a single type of object, it now
 * creates multiple of objects that are somewhat related. These objects do not
 * have to be related to each other with a common interface. 
 * 
 * benefit:
 * - prevents showing concrete implementing classes, like factories should
 * 
 * - since all 
 * 
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
		
		Ingredient item = ifactory.getNewIngredient();
		
		System.out.println( item.isAnyGood() );
		
	}
}

/*
 * make interfaces that are somewhat related
 */
interface Material
{
	String isValuable();
}

interface Ingredient
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
}

class GoodMaterial implements Material
{
	@Override
	public String isValuable()
	{
		return "ggoooolllddd!!!";
	}
}

class BadIngredient implements Ingredient
{
	@Override
	public String isAnyGood()
	{
		return "definetely rotten";
	}
}

class GoodIngredient implements Ingredient
{
	@Override
	public String isAnyGood()
	{
		return "fresh and peachy";
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

