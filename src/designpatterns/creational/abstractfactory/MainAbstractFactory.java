package designpatterns.creational.abstractfactory;

/**
 * @see factory method pattern
 * 
 * Abstract Factory Pattern
 * 
 * 
 * 
 * 
 * 
 * benefit:
 * - the added abstraction layer removes dependencies 
 * - no new code needed to include new factories, just pass the interface
 * - 
 * 
 * troubles:
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
 * 
 */
interface Item
{
	String getName();
}

interface Loot extends Item
{
	String isValuable();
}

interface Ingredient extends Item
{
	String isAnyGood();
}

class BadLoot implements Loot
{
	@Override
	public String isValuable()
	{
		return "meh..";
	}

	@Override
	public String getName()
	{
		return "bad loot";
	}
}

class GoodLoot implements Loot
{
	@Override
	public String isValuable()
	{
		return "boss weapons!!";
	}

	@Override
	public String getName()
	{
		return "good loot";
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
 * 
 */
interface ItemFactory
{
	Loot getNewLoot();
	Ingredient getNewIngredient();
}

class BadItemFactory implements ItemFactory
{
	@Override
	public Loot getNewLoot()
	{
		return new BadLoot();
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
	public Loot getNewLoot()
	{
		return new GoodLoot();
	}

	@Override
	public Ingredient getNewIngredient()
	{
		return new GoodIngredient();
	}
}

