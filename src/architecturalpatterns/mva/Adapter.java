package architecturalpatterns.mva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * a.k.a. "mediating controller" between the interface and data
 * 
 * The adapter determines the implementation of the business logic of the 
 * application. Here we specify what command is connected to the View. In
 * this example I'm using the command pattern to split responsibility into
 * a different class. If you're not using the command pattern, you would
 * add the calculation code in the adapter itself. 
 * 
 */
class Adapter
{
	private Model model;
	private View view;
	
	public Adapter(Model m, View v)
	{
		model = m;
		view = v;
		
		// using the AWT build-in command pattern
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
 * like the Adapter class. Which makes these commands Adapters as well.
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
			// you could update the UI with an error
			return;
		}
		
		model.addition(n1, n2);
		int nR = model.getResult();
		view.setResult(""+nR);
	}
}
