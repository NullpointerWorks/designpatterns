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
	
	public void setVisible(boolean b) 
	{
		window.setVisible(b);
    }
	
	public int getNumberOne()
	{
		return Integer.parseInt( number1.getText() );
	}
	
	public int getNumberTwo()
	{
		return Integer.parseInt( number2.getText() );
	}
	
	public void setResult(int n)
	{
		numberR.setText(""+n);
	}
	
	public void addCalculationListener(ActionListener al)
	{
		calc.addActionListener(al);
	}
}
