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
		new MainCommand();
	}
	
	public MainCommand()
	{
		CommandHistory history = new CommandHistory();
		
		JPanel panel = new JPanel();
		panel.setSize(400,320);
		panel.setPreferredSize(panel.getSize());
		
		Button button = new Button();
		button.setText("Click me!!");
		button.setSize(140,40);
		button.setPreferredSize(button.getSize());
		button.setCommand(new ClickCommand(), history);
		panel.add(button);
		
		JFrame window = new JFrame();
		window.add(panel);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}

class Button extends JButton implements ActionListener
{
	private static final long serialVersionUID = -5245394995966152954L;
	
	private CommandHistory history;
	private Command command = new NullCommand();
	
	public Button()
	{
		addActionListener(this);
	}
	
	public void setCommand(Command cmd, CommandHistory his)
	{
		command = cmd;
		history = his;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		history.push(command);
		command.execute();
	}
}

/*
 * command interface
 */
interface Command
{
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
	public ClickCommand()
	{
		
	}
	
	@Override
	public void execute() 
	{
		System.out.println("Executing a clicking command..");
	}
}

/*
 * a class to keep track of all previous commands.
 */
class CommandHistory
{
	private List<Command> history = new ArrayList<Command>();
	
	public CommandHistory() {}
	
	public void push(Command cmd)
	{
		history.add(cmd);
	}
	
	public Command pop()
	{
		int i = history.size()-1;
		return history.remove(i);
	}
}
