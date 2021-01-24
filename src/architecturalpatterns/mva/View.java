package architecturalpatterns.mva;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * front-end
 * 
 * The adapter is responsible for setting commands for this View object. This keeps
 * the View oblivious of the Adapter using it making the UI code reusable. 
 * 
 * You could choose not to use the Command pattern, but you'd need to add a reference 
 * of the Adapter in the View to call a method when the button is pressed.
 * 
 */
class View
{
	private JFrame window;
	private JTextField number1;
	private JTextField number2;
	private JTextField numberR;
	private JButton calc;
	
	public View()
	{
		number1 = new JTextField();
		number1.setSize(60, 28);
		number1.setPreferredSize( number1.getSize() );
		
		number2 = new JTextField();
		number2.setSize(60, 28);
		number2.setPreferredSize( number2.getSize() );
		
		numberR = new JTextField();
		numberR.setSize(100, 28);
		numberR.setPreferredSize( numberR.getSize() );
		
		JLabel label = new JLabel("+");
		
		calc = new JButton();
		calc.setText("=");
		
		JPanel panel = new JPanel();
		panel.add(number1);
		panel.add(label);
		panel.add(number2);
		panel.add(calc);
		panel.add(numberR);
		
		window = new JFrame();
		window.add(panel);
		window.pack();
		window.setTitle("MVA");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	}
	
	/*
	 * getters
	 */
	public String getNumberOne()
	{
		return number1.getText();
	}
	
	public String getNumberTwo()
	{
		return number2.getText();
	}
	
	/*
	 * setters
	 */
	public void setVisible(boolean b) 
	{
		window.setVisible(b);
    }
	
	public void setResult(String n)
	{
		numberR.setText(n);
	}
	
	/*
	 * commands
	 */
	public void addCalculationListener(ActionListener al)
	{
		calc.addActionListener(al);
	}
}
