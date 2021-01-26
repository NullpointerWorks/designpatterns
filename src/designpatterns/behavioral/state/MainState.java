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
		Machine machine = new Machine();
		State grow = new Growing();
		State reduce = new Reducing();
		
		float n1 = 5f;
		float n2 = 2f;
		float nR = 0f;
		
		machine.setState(grow);

		nR = machine.operation(n1, n2);
		System.out.println("= "+nR);
		nR = machine.factor(n1, n2);
		System.out.println("= "+nR);
		
		machine.setState(reduce);

		nR = machine.operation(n1, n2);
		System.out.println("= "+nR);
		nR = machine.factor(n1, n2);
		System.out.println("= "+nR);
	}
}

/*
 * 
 */
class Machine
{
	private State operations;
	
	public void setState(State s)
	{
		operations = s;
	}
	
	public float operation(float n1, float n2) 
	{
		return operations.operation(n1, n2);
	}
	
	public float factor(float n1, float n2) 
	{
		return operations.factor(n1, n2);
	}
}

/*
 * 
 */
interface State
{
	float operation(float n1, float n2);
	float factor(float n1, float n2);
}

/*
 * 
 */
class Growing implements State
{
	@Override
	public float operation(float n1, float n2) 
	{
		return n1 + n2;
	}

	@Override
	public float factor(float n1, float n2) 
	{
		return n1 * n2;
	}
}

/*
 * 
 */
class Reducing implements State
{
	@Override
	public float operation(float n1, float n2) 
	{
		return n1 - n2;
	}
	
	@Override
	public float factor(float n1, float n2) 
	{
		return n1 / n2;
	}
}
