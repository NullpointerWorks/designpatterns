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
 * 
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
