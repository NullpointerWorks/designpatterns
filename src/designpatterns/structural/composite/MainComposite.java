package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite Pattern
 * 
 * 
 * 
 * 
 * 
 * benefit:
 * 
 * troubles:
 */
public class MainComposite
{
	public static void main(String[] args)
	{
		
		Tree branch1 = new Tree();
		branch1.add( new Leaf() );
		branch1.add( new Leaf() );
		branch1.add( new Leaf() );
		
		Tree branch3 = new Tree();
		branch3.add( new Leaf() );
		branch3.add( new Leaf() );
		
		Tree branch2 = new Tree();
		branch2.add( branch3 );
		branch2.add( new Leaf() );
		branch2.add( new Leaf() );
		
		Tree root = new Tree();
		root.add( branch1 );
		root.add( branch2 );
		
		System.out.println( "amount of leafs: " + root.execute() );
		
		System.out.println( "amount of leafs: " + branch2.execute() );
		
	}
}

/*
 * make a simple interface that denotes a task to be performed
 */
interface Composite
{
	int execute();
}

/*
 * make a node and end-point implementing the interface
 * 
 * the node class "Tree" has to ability to aggregate composites. 
 * when the task is executed, it delegates the task to all end-
 * points.
 */
class Tree implements Composite
{
	private List<Composite> composites;
	
	public Tree()
	{
		composites = new ArrayList<Composite>();
	}
	
	public void add(Composite c)
	{
		composites.add(c);
	}
	
	public void remove(Composite c)
	{
		if (composites.contains(c)) composites.remove(c);
	}
	
	public List<Composite> children()
	{
		return composites;
	}
	
	@Override
	public int execute() 
	{
		int sum = 0;
		for (Composite c : composites)
		{
			sum += c.execute();
		}
		return sum;
	}
}

class Leaf implements Composite
{
	@Override
	public int execute() 
	{
		return 1;
	}
}
