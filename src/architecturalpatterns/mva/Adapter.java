package architecturalpatterns.mva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * a.k.a. "mediating controller" between the interface and data
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
