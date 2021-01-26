package designpatterns.behavioral.template;

/**
 * Template Pattern
 * 
 * 
 * 
 */
public class MainTemplate 
{
	public static void main(String[] args) 
	{
		Game soccer = new SoccerMatch();
		soccer.play();
		
		Game invaders = new SpaceInvaderGame();
		invaders.play();
	}
}

/*
 * Define an interface to add extra abstraction. In this case
 * it's optional since the abstract class defined the same 
 * methods. You could opt to remove the interface, or the 
 * abstract methods.
 */
interface Game
{
	void play();
	void start();
	void pause();
	void end();
}

/*
 * define an abstract class that provides a final template 
 * method and a few abstract methods to be implemented.
 */
abstract class AbstractGame implements Game
{
	public abstract void start();
	public abstract void pause();
	public abstract void end();
	
	// this implemented method is declared final to prevent subclasses from breaking the pattern
	public final void play()
	{
		start();
		pause();
		end();
	}
}

/*
 * using the game template to implement a soccer match
 */
class SoccerMatch extends AbstractGame
{
	@Override
	public void start() 
	{
		System.out.println("Coin has been flipped. Ball is on the move!");
	}
	
	@Override
	public void pause() 
	{
		System.out.println("Halftime reached. 15 minute break.");
	}
	
	@Override
	public void end() 
	{
		System.out.println("End score is 1-0. We have a winner.");
	}
}

/*
 * using the game template to implement a game of space invaders
 */
class SpaceInvaderGame extends AbstractGame
{
	@Override
	public void start() 
	{
		System.out.println("Insert coin.");
	}
	
	@Override
	public void pause() 
	{
		System.out.println("Pausing the game for a moment.");
	}
	
	@Override
	public void end() 
	{
		System.out.println("Game Over!");
	}
}
