package designpatterns.behavioral.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

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
		History history = new CommandHistory();
		
		JPanel panel = new JPanel();
		panel.setSize(400,320);
		panel.setPreferredSize(panel.getSize());
		
		JButton button = new JButton();
		button.setText("Click me!!");
		button.setSize(140,40);
		button.setPreferredSize(button.getSize());
		button.addActionListener( new ClickCommand(history) );
		panel.add(button);
		
		JFrame window = new JFrame();
		window.add(panel);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}

/*
 * command interface hijacking the AWT ActionListener
 */
interface Command extends ActionListener
{
	default void actionPerformed(ActionEvent e) 
	{
		execute();
	}
	
	void execute();
}

class NullCommand implements Command
{
	public NullCommand() {}
	
	@Override
	public void execute() {}
}

class ClickCommand implements Command
{
	History history;
	
	public ClickCommand(History his)
	{
		history = his;
	}
	
	@Override
	public void execute() 
	{
		history.push(this);
		System.out.println("Executing a clicking command..");
	}
}

/*
 * a class to keep track of all previous commands.
 */
interface History
{
	void push(Command cmd);
	Command pop();
}

class CommandHistory implements History
{
	private List<Command> history = new ArrayList<Command>();
	
	@Override
	public void push(Command cmd)
	{
		history.add(cmd);
	}
	
	@Override
	public Command pop()
	{
		int i = history.size()-1;
		return history.remove(i);
	}
}
