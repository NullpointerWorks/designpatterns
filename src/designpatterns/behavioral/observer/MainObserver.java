package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern
 * 
 * 
 * 
 */
public class MainObserver 
{
	public static void main(String[] args) 
	{
		Publisher pub = new Publisher();
		
		Observer con1 = new ConcreteObserver("observer1");
		Observer con2 = new ConcreteObserver("observer2");
		
		pub.addObserver(con1);
		pub.addObserver(con2);
		pub.changeState("Hello World!");

		Observer con3 = new ConcreteObserver("observer3");
		Observer con4 = new ConcreteObserver("observer4");
		pub.removeObserver(con1);
		pub.addObserver(con3);
		pub.addObserver(con4);
		
		pub.changeState("A new message..");
	}
}

/*
 * An observer interface that listens to events fired from 
 * the publisher. This pattern can be found regularly in
 * the Java standard library as event listeners. Think;
 * KeyListener, MouseListener, ActionListener, etc.
 * 
 * in this example we'll invent one for ourselves.
 */
interface Observer
{
	void onUpdate(String context);
}

/*
 * Make a concrete class of something that's interested in
 * the changes it might listen to.
 */
class ConcreteObserver implements Observer
{
	private String name = "";
	
	public ConcreteObserver(String n)
	{
		name = n;
	}
	
	@Override
	public void onUpdate(String context) 
	{
		System.out.println(name+" > "+context);
	}
}

/*
 * The event sending class needs a little infrastructure to
 * facilitate the subscription and event handling.
 */
class Publisher
{
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer ob)
	{
		if (!observers.contains(ob)) observers.add(ob);
	}
	
	public void removeObserver(Observer ob)
	{
		if (observers.contains(ob)) observers.remove(ob);
	}
	
	private void notifyObservers(String context)
	{
		for (Observer ob : observers)
		{
			ob.onUpdate(context);
		}
	}
	
	/*
	 * invent some state for this object to use
	 */
	private String state = "";
	
	public void changeState(String s)
	{
		state = s;
		notifyObservers(state);
	}
}
