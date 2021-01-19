package designpatterns.behavioral.iterator;

/**
 * Iterator Pattern
 * 
 * The primary purpose of an iterator is to hide the internal implementation of a list.
 * This helps prevent the programmer from modifying the content of the list and not 
 * disturb any background algorithms that may be running. In other words, it helps to
 * keep the integrity of the list.
 * 
 * The neat thing about an iterator is that it can be implemented using a while loop.
 * The implementation will need two methods. One to determine if the end of the list has 
 * been found, and another to expose an element of the list.
 * 
 */
public class MainIterator
{
	public static void main(String[] args)
	{
		// make a list for demonstration
		String[] myArray = {"Apple", "Banana", "Peach", "Mango", "Lemon", "Grape"};
		
		// when a routine is requesting its content, pour the raw list/array into a constructor to make an iterator.
		Iterator<String> it = new Iterator<String>( myArray );
		
		// loop through the list while shielding the list's implementation from the user
		while(it.hasNext())
		{
			String next = it.getNext();
			System.out.println(next);
		}
	}
}

/*
 * the iterator can be made more advanced by adding a reset, index and size method to get more information about the list.
 */
interface IIterator<Clazz>
{
	boolean hasNext();
	Clazz getNext();
	
	int index();
	int size();
	void reset();
}

/*
 * an implementation with a simple raw array constructor
 */
class Iterator<C> implements IIterator<C>
{
	private int index;
	private C[] internal;
	
	public Iterator(C[] list)
	{
		index = 0;
		internal = list;
	}
	
	@Override
	public boolean hasNext() 
	{
		return index < internal.length;
	}
	
	@Override
	public C getNext() 
	{
		return internal[index++];
	}

	@Override
	public int index() 
	{
		return index++;
	}

	@Override
	public int size() 
	{
		return internal.length;
	}

	@Override
	public void reset() 
	{
		index = 0;
	}
}
