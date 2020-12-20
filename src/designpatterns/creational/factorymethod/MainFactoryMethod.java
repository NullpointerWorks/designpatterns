package designpatterns.creational.factorymethod;

/**
 * @see simple factory pattern
 * 
 * definition: "Define an interface for creating an object, but let 
 * subclasses decide which class to instantiate. Factory Method lets 
 * a class defer instantiation to subclasses"
 * 
 * Factory method pattern adds a layer of abstraction compared to the 
 * "simple factory".
 * 
 * benefit:
 * - the added abstraction layer removes dependencies 
 * - no new code needed to include new factories, just pass the interface
 * - 
 * 
 * troubles:
 * 
 */
public class MainFactoryMethod
{
	public static void main(String[] args)
	{
		
		MobFactory mf = new FriendlyFactory();
		
		Mob newMob = mf.getNewMob();
		
		System.out.println( newMob.isFriendly() );
		
	}
}

/*
 * we have a general purpose " mob" interface. This can be used for enemies, friendlies, other NPC's, etc.
 */
interface Mob
{
	String isFriendly();
}

/*
 * implement the mobs you want to use
 */
class FriendlyMob implements Mob
{
	@Override
	public String isFriendly()
	{
		return "very friendly";
	}
}

class UnFriendlyMob implements Mob
{
	@Override
	public String isFriendly()
	{
		return "will drink your blood!";
	}
}

/*
 * generalize the factories with an interface.
 * this is the "factory method"
 */
interface MobFactory
{
	Mob getNewMob();
}

/*
 * make factories for different categories of mobs.
 * these factories can have their own decision logic
 */
class FriendlyFactory implements MobFactory
{
	@Override
	public Mob getNewMob()
	{
		return new FriendlyMob();
	}
}

class UnFriendlyFactory implements MobFactory
{
	@Override
	public Mob getNewMob()
	{
		return new UnFriendlyMob();
	}
}
