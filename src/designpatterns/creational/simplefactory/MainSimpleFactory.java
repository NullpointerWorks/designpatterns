package designpatterns.creational.simplefactory;

import java.util.Random;   

/**
 * Simple Factory Pattern 
 * 
 * This pattern is used when the instantiation of objects require complex algorithms, or when it's not always 
 * clear what sort of subclass is required, or need to take specific configurations into account. They can be 
 * rather simple or very complicated. Either way, factories are usually beneficial to your project.
 * 
 * For example, the creation of enemies in a game may depend on a random factor along side the state of the 
 * game. The creation is therefore encapsulated inside the factory, instead of the calling class.
 * 
 * 
 * benefit:
 * - makes debugging easier by localizing creation code
 * - separates the calling class's logic from the creation logic
 * - decouples dependencies
 * - makes future instantiation a lot easier to code
 * 
 * troubles:
 * - the factory does not have an interface to generalize the functionality. 
 * - a simple solution to a simple problems, but doesn't solve growing problems
 * 
 */
public class MainSimpleFactory
{
	public static void main(String[] args)
	{
		// by instantiating a new factory object
		EnemyFactory ef = new EnemyFactory();
		Enemy enemy = ef.getNewEnemy();
		System.out.println("HP: "+enemy.getHitPoints() );
	}
}
   
abstract class Enemy
{  
	protected int hp;  
	abstract int getHitPoints(); 
}


class EasyEnemy extends Enemy
{

	@Override
	int getHitPoints()
	{
		return 10;
	}
	
}

class MediumEnemy extends Enemy
{

	@Override
	int getHitPoints()
	{
		return 20;
	}
	
}

class HardEnemy extends Enemy
{

	@Override
	int getHitPoints()
	{
		return 40;
	}
	
}

/*
 * simple factory, no abstraction
 */
class EnemyFactory
{
	/*
	 * makes a new object
	 */
	public Enemy getNewEnemy()
	{  
		float rand = new Random().nextFloat();
		
		if (rand < 0.2f) // 20%
		{
			return new HardEnemy();
		}
		
		if (rand < 0.6f) // 40%
		{
			return new MediumEnemy();
		}
		
		return new EasyEnemy();
	}  
}
