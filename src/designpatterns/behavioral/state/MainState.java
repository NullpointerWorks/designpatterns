package designpatterns.behavioral.state;

/**
 * State Pattern
 * 
 * 
 * 
 */
public class MainState 
{
	public static void main(String[] args) 
	{
		State archer = new ArcherMachine();
		State soldier = new SoldierMachine();
		State wizard = new WizardMachine();
		
		Machine machine = new Machine();
		
		machine.setState(archer);
		machine.doMovement();
		machine.doAttack();
		machine.doHeal();
		System.out.println();
		machine.setState(soldier);
		machine.doMovement();
		machine.doAttack();
		machine.doHeal();
		System.out.println();
		machine.setState(wizard);
		machine.doMovement();
		machine.doAttack();
		machine.doHeal();
	}
}

/*
 * 
 */
class Machine
{
	private State operations;
	
	public Machine()
	{
		
	}
	
	public void setState(State s)
	{
		operations = s;
	}
	
	public void doMovement() 
	{
		operations.doMovement();
	}
	
	public void doAttack() 
	{
		operations.doAttack();
	}
	
	public void doHeal() 
	{
		operations.doHeal();
	}
}

/*
 * 
 */
interface State
{
	void doMovement();
	void doAttack();
	void doHeal();
}

/*
 * 
 */
class ArcherMachine implements State
{
	@Override
	public void doMovement() 
	{
		System.out.println("Sneaking to my target...");
	}
	
	@Override
	public void doAttack() 
	{
		System.out.println("Fireing my bow!");
	}
	
	@Override
	public void doHeal() 
	{
		System.out.println("Drinking a potion");
	}
}

/*
 * 
 */
class SoldierMachine implements State
{
	@Override
	public void doMovement() 
	{
		System.out.println("Marching to my waypoint.");
	}
	
	@Override
	public void doAttack() 
	{
		System.out.println("Chaaarrggeee!");
	}
	
	@Override
	public void doHeal() 
	{
		System.out.println("Taking my regeneration potion.");
	}
}

/*
 * 
 */
class WizardMachine implements State
{
	@Override
	public void doMovement() 
	{
		System.out.println("Gliding to a superiour position.");
	}
	
	@Override
	public void doAttack() 
	{
		System.out.println("You shall not passs!");
	}
	
	@Override
	public void doHeal() 
	{
		System.out.println("Casting my self-heal spell.");
	}
}
