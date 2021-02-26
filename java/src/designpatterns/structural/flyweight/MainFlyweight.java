package designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Flyweight Pattern
 * 
 * 
 * 
 */
public class MainFlyweight
{
	public static void main(String[] args) 
	{
		final String line = "Text to be parsed by the pattern.";
		
		FlyweightList flyweight = new FlyweightList();
		LetterWrapper[] sentence = flyweight.getText(line);
		
		System.out.print("requested text : ");
		for (LetterWrapper lw : sentence)
		{
			System.out.print(lw.getLetter());
		}
		System.out.print("\nstored letters : ");
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
	private Map<String, LetterWrapper> letters;
	
	public FlyweightList()
	{
		letters = new HashMap<String, LetterWrapper>();
	}
	
	public LetterWrapper[] getText(String line) 
	{
		int i=0;
		int l=line.length();
		LetterWrapper[] arr = new LetterWrapper[l];
		
		for (; i<l; i++)
		{
			arr[i] = add(line.substring(i,i+1));
		}
		
		return arr;
	}

	public LetterWrapper add(String letter)
	{
		LetterWrapper lw;
		
		if (letters.containsKey(letter))
		{
			lw = letters.get(letter);
		}
		else
		{
			lw = new LetterWrapper(letter);
			letters.put(letter, lw);
		}
		
		return lw;
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


