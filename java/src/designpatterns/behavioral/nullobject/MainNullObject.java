package designpatterns.behavioral.nullobject;

/**
 * Null Object Pattern
 * 
 * 
 * 
 */
public class MainNullObject 
{
	public static final int CAT = 0;
	public static final int DOG = 1;
	public static final int SHEEP = 2;
	
	public static void main(String[] args) 
	{
		// makes a sound
		Animal myAnimal = newAnimal(CAT);
		myAnimal.makeSound();
		
		// null, stays silent
		myAnimal = newAnimal(4);
		myAnimal.makeSound();
	}
	
	public static Animal newAnimal(int ID)
	{
		switch(ID)
		{
		case CAT: return new Cat();
		case DOG: return new Dog();
		case SHEEP: return new Sheep();
		}
		
		//return null;
		return new NullAnimal();
	}
	
}

/*
 * define an interface for an animal
 */
interface Animal
{
	void makeSound();
}

/*
 * make some concrete animals
 */
class Cat implements Animal
{
	@Override
	public void makeSound() 
	{
		System.out.println("Meow");
	}
}

class Dog implements Animal
{
	@Override
	public void makeSound() 
	{
		System.out.println("Bark");
	}
}

class Sheep implements Animal
{
	@Override
	public void makeSound() 
	{
		System.out.println("Blahaha");
	}
}

/*
 * add an empty implementation to act as a null placeholder
 */
class NullAnimal implements Animal
{
	@Override
	public void makeSound() 
	{
		
	}
}
