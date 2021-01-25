package architecturalpatterns.mvc1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * mediating controller between the user-interface and data
 */
class Controller
{
	private Model model;
	private View view;
	
	public Controller(Model m, View v)
	{
		model = m;
		view = v;
		
		// using AWT build-in command pattern
		view.addCalculationListener( new AdditionCommand(model,view) );
	}
}

/*
 * make a command for the button
 * 
 * The String to Integer conversion could be done in the View object, but
 * this can be done in the View as well. When you place the responsibility
 * is up to you.
 * 
 * Note: The command implementation knows about the View and the Model, just
 * like the Controller class. So in essence, commands are also Controller.
 * 
 */
class AdditionCommand implements ActionListener
{
	private Model model;
	private View view;
	
	public AdditionCommand(Model m, View v)
	{
		model = m;
		view = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String s1 = view.getNumberOne();
		String s2 = view.getNumberTwo();
		int n1,n2;
		
		try
		{
			n1 = Integer.parseInt(s1);
			n2 = Integer.parseInt(s2);
		}
		catch(NumberFormatException ex)
		{
			System.err.println("Please enter two integer numbers");
			// perhaps update the UI with an error message
			return;
		}
		
		model.addition(n1, n2);
		int nR = model.getResult();
		view.setResult(""+nR);
	}
}
