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
		view.addCalculationListener( new AdditionCommand(model,view) );
	}
}

/*
 * make a command for the button
 * 
 * The String to Integer conversion could be done in the View object, but
 * this can be done in the View as well. When you place the responsibility
 * is up to you.
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
		try
		{
			int n1 = view.getNumberOne();
			int n2 = view.getNumberTwo();
			model.addition(n1, n2);
			int nR = model.getResult();
			view.setResult(nR);
		}
		catch(NumberFormatException ex)
		{
			System.err.println("Please enter two integer numbers");
		}
	}
}
