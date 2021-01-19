package designpatterns.behavioral.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JPanel panel = new JPanel();
		panel.setSize(400,320);
		panel.setPreferredSize(panel.getSize());
		
		Button button = new Button();
		button.setText("Save command");
		button.setSize(140,40);
		button.setPreferredSize(button.getSize());
		button.setCommand(new SaveCommand());
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
	
	public Command command;
	
	public Button()
	{
		super();
		command = new NullCommand();
		addActionListener(this);
	}
	
	public void setCommand(Command cmd)
	{
		command = cmd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
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

class SaveCommand implements Command
{
	public SaveCommand()
	{
		
	}
	
	@Override
	public void execute() 
	{
		System.out.println("Executing save command..");
	}
}
