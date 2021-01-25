package designpatterns.behavioral.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Mediator Pattern
 * 
 * User forms can have complex interactions like hidden fields that 
 * become visible when a check box is marked. Buttons that validate 
 * data and display messages in text fields and turns then red to 
 * indicate an error.
 * 
 */
public class MainMediator 
{
	public static void main(String[] args) 
	{
		Mediator mediator = new Mediator();
		
		JTextField textfield1 = new MediatedJTextField(mediator);
		textfield1.setSize(140,24);
		textfield1.setPreferredSize(textfield1.getSize());
		
		JPasswordField textfield2 = new MediatedJPasswordField(mediator);
		textfield2.setSize(140,24);
		textfield2.setPreferredSize(textfield2.getSize());
		textfield2.setEchoChar('*');
		
		JButton button1 = new MediatedJButton(mediator);
		button1.setText("Log in");
		button1.setSize(140,24);
		button1.setPreferredSize(button1.getSize());
		
		JCheckBox checkbox1 = new MediatedJCheckBox(mediator);
		checkbox1.setText("Remember me");
		checkbox1.setSize(140,24);
		checkbox1.setPreferredSize(checkbox1.getSize());
		
		JPanel panel = new JPanel();
		panel.setSize(160,120);
		panel.setPreferredSize(panel.getSize());
		panel.add(textfield1);
		panel.add(textfield2);
		panel.add(button1);
		panel.add(checkbox1);
		mediator.setUserTextField(textfield1);
		mediator.setPasswordField(textfield2);
		mediator.setLoginButton(button1);
		mediator.setRememberMe(checkbox1);
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.validate();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/*
 * define an interface for the mediator
 */
interface IMediator 
{
	// can't use the name "notify". its a final method of the Object superclass
	void onNotify(Object sender);
}

class Mediator implements IMediator 
{
	private JTextField user;
	private JPasswordField pass;
	private JButton login;
	private JCheckBox remember;
	
	public void setRememberMe(JCheckBox cb) {remember = cb;}
	public void setLoginButton(JButton btn) {login = btn;}
	public void setUserTextField(JTextField tf) {user = tf;}
	public void setPasswordField(JPasswordField tf) {pass = tf;}
	
	@Override
	public void onNotify(Object sender) 
	{
		if (sender == user)
		{
			//System.out.println( "User field is being editted" );
		}
		else
		if (sender == pass)
		{
			//System.out.println( "Password field is being editted" );
		}
		else
		if (sender == login)
		{
			System.out.println( "Logging in" );
			System.out.println( user.getText() + " - " + new String(pass.getPassword()) );
		}
		else
		if (sender == remember)
		{
			JCheckBox cb = (JCheckBox)sender;
			System.out.println( "Remember me "+(cb.isSelected()?"enabled":"disabled") );
		}
	}
}

/*
 * Mediator extension for a JTextField
 */
class MediatedJTextField extends JTextField implements KeyListener
{
	private static final long serialVersionUID = 4228695953319405253L;
	
	private IMediator m;
	
	public MediatedJTextField(IMediator med)
	{
		m = med;
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		m.onNotify(this);
	}
}

/*
 * Mediator extension for a JPasswordField
 */
class MediatedJPasswordField extends JPasswordField implements KeyListener
{
	private static final long serialVersionUID = 4228695953319405253L;
	
	private IMediator m;
	
	public MediatedJPasswordField(IMediator med)
	{
		m = med;
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		m.onNotify(this);
	}
}

/*
 * Mediator extension for a JButton
 */
class MediatedJButton extends JButton implements ActionListener
{
	private static final long serialVersionUID = 4228695953319405253L;
	
	private IMediator m;
	
	public MediatedJButton(IMediator med)
	{
		m = med;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		m.onNotify(this);
	}
}

/*
 * Mediator extension for a JCheckBox
 */
class MediatedJCheckBox extends JCheckBox implements ActionListener
{
	private static final long serialVersionUID = 4228695953319405253L;
	
	private IMediator m;
	
	public MediatedJCheckBox(IMediator med)
	{
		m = med;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		m.onNotify(this);
	}
}
