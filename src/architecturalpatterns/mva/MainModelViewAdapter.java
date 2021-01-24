package architecturalpatterns.mva;

/**
 * Model-View-Adapter Pattern
 * 
 * Note: the MVA adapter class is not related to the Adapter Pattern
 * 
 * Similar to MVC and MVP, this is another approach to separate the front-end from 
 * the back-end. The aim of MVA is to entirely decoupling the Model and View making 
 * sure all interaction is done through the Adapter class. 
 * 
 * The example below lets the Adapter have full control over the Model and the View.
 * As a result, the Adapter tells the View when to do with UI input, and queries the
 * Model for calculations and results. The connection from the UI to the Adapter is 
 * done with using the Command pattern with the Standard Library's ActionListener. 
 * The Adapter sets the command when initializing which keeps the View unaware of 
 * the controlling object.
 * 
 */
public class MainModelViewAdapter
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		new Adapter(model, view);
		view.setVisible(true);
	}
}
