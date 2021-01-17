package designpatterns.behavioral.command;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Command Pattern
 * 
 * 
 * 
 */
public class MainCommand
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,320);
		window.setPreferredSize(window.getSize());
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		JPanel panel = new JPanel();
		
		
		
		
		
		
		
		
		
	}
}

/*
 * command interface
 */
interface Command
{
	void execute();
}

class SaveCommand implements Command
{
	public SaveCommand()
	{
		
	}
	
	@Override
	public void execute() 
	{
		
	}
}

class LoadCommand implements Command
{
	public LoadCommand()
	{
		
	}
	
	@Override
	public void execute() 
	{
		
	}
}

class CopyCommand implements Command
{
	public CopyCommand()
	{
		
	}
	
	@Override
	public void execute() 
	{
		
	}
}
