package designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Flyweight Pattern
 * 
 * 
 */
public class MainFlyweight
{
	public static void main(String[] args) 
	{
		final String line = "Test to be parsed by the pattern.";
		
		/*
		 * parse and show the line of text without using a flyweight
		 */
		List<LetterWrapper> letters = new ArrayList<LetterWrapper>();
		for (int i=0,l=line.length(); i<l; i++)
		{
			String letter = line.substring(i,i+1);
			LetterWrapper lw = new LetterWrapper(letter);
			letters.add(lw);
		}
		for (LetterWrapper lw : letters)
		{
			System.out.print(lw.getLetter());
		}
		System.out.println();
		
		/*
		 * 
		 */
		FlyweightList flyweight = new FlyweightList();
		for (int i=0,l=line.length(); i<l; i++)
		{
			String letter = line.substring(i,i+1);
			flyweight.add(letter);
		}
		flyweight.showLetters();
		
		
		
	}
}

/*
 * a wrapper around a String letter to resemble a resource
 */
class LetterWrapper
{
	private final String letter;
	
	public LetterWrapper(String l)
	{
		letter = l;
	}
	
	public String getLetter() {return letter;}
	
	public boolean equals(String letter)
	{
		return this.letter.equals(letter);
	}
}

/*
 * 
 */
class FlyweightList
{
	private Map<String, LetterWrapper> letters = new HashMap<String, LetterWrapper>();
	
	public FlyweightList()
	{
		
	}
	
	public void add(String letter)
	{
		if (!letters.containsKey(letter))
		{
			LetterWrapper lw = new LetterWrapper(letter);
			letters.put(letter, lw);
		}
	}
	
	public void showLetters()
	{
		Set<Entry<String, LetterWrapper>> set = letters.entrySet();
		for (Entry<String, LetterWrapper> entry : set)
		{
			System.out.print( entry.getValue().getLetter() );
		}
	}
}


