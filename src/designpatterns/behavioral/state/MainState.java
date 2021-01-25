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
	
}

/*
 * 
 */
interface State
{
	
	
}


