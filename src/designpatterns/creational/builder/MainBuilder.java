package designpatterns.creational.builder;

/*
 * Builder pattern
 * 
 * 
 * 
 */
public class MainBuilder 
{
	public static void main(String[] args) 
	{
		/*
		 * first mix some concrete.
		 */
		ConcreteBuilder builder1 = new ConcreteBuilder();
		
		Director dir = new Director(builder1);
		dir.make(TypeSelect.SIMPLE);
		
		ConcreteProduct product1 = builder1.getResult();
		System.out.println( product1.getDescription() );
		
		/*
		 * next, make a piece of carpet
		 */
		CarpetBuilder builder2 = new CarpetBuilder();
		
		dir.changeBuilder(builder2);
		dir.make(TypeSelect.ADVANCED);
		
		CarpetProduct product2 = builder2.getResult();
		System.out.println( product2.getDescription() );
		
	}
}

/*
 * This enum is only used to select between creation types. 
 * It's not a specifically part of the builder pattern.
 */
enum TypeSelect
{
	SIMPLE,
	ADVANCED
}

/*
 * builder pattern's core. this class determines what steps are needed to construct the desired object
 */
class Director
{
	private Builder builder;
	
	public Director(Builder b)
	{
		changeBuilder(b);
	}
	
	public void changeBuilder(Builder b)
	{
		builder = b;
	}
	
	public void make(TypeSelect type)
	{
		builder.reset();
		switch(type)
		{
		case SIMPLE: 
			builder.doStepA();
			break;
		case ADVANCED:
			builder.doStepA();
			builder.doStepB();
		}
	}
}

/*
 * builders compatible with our director should have the methods below
 */
interface Builder
{
	void reset();
	void doStepA();
	void doStepB();
}

/*
 * implement two builders with product specific information.
 * they have an additional method that returns the product not specified 
 * in the interface.
 */
class ConcreteBuilder implements Builder
{
	private String material;
	private String strength;
	
	@Override
	public void reset() 
	{
		material = "";
		strength = "solid";
	}

	@Override
	public void doStepA() 
	{
		material = "concrete";
	}

	@Override
	public void doStepB() 
	{
		strength = "steel mesh";
	}
	
	public ConcreteProduct getResult()
	{
		return new ConcreteProduct(material, strength);
	}
}

class CarpetBuilder implements Builder
{
	private String color;
	private String fluffiness;
	
	@Override
	public void reset() 
	{
		color = "";
		fluffiness = "stiff";
	}

	@Override
	public void doStepA() 
	{
		color = "beige";
	}

	@Override
	public void doStepB() 
	{
		fluffiness = "soft";
	}
	
	public CarpetProduct getResult()
	{
		return new CarpetProduct(color, fluffiness);
	}
}

/*
 * two unrelated products with their own creation logic.
 * in this example, they still look alike
 */
class ConcreteProduct
{
	private String material;
	private String strength;
	
	public ConcreteProduct(String mat, String str) 
	{
		material=mat;
		strength=str;
	}
	
	public String getDescription()
	{
		return strength + " " + material;
	}
}

class CarpetProduct
{
	private String color;
	private String fluffiness;
	
	public CarpetProduct(String col, String flf) 
	{
		color=col;
		fluffiness=flf;
	}
	
	public String getDescription()
	{
		return color + " " + fluffiness;
	}
}
