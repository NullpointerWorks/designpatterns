package architecturalpatterns.mvc;

/**
 * TODO
 * 
 * Model-View-Controller Pattern
 * 
 * An architectural pattern to help separate UI code from the back-end code. 
 * The user interacts with the controller which updates the Model which in 
 * turn updates the View. The structure has a triangular relationship in 
 * which the controller does not know about view, but knows how to access
 * the model. 
 * 
 * Unlike in MVA, this pattern allows for communication among the view and 
 * the model keeping the controller unaware. 
 * 
 * The View is responsible for displaying information, but may also take some 
 * user input, like pressing buttons, checkboxes and fields. Though input
 * may also take the form of a USB device which bypasses the UI.
 * 
 * 
 * 
 * 
 */
public class MainModelViewController
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Controller ctrl = new Controller();
		
		ctrl.setDependency(model, view);
		model.setDependency(view);
		
		
	}
}


