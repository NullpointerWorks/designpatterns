package architecturalpatterns.mvc;

/**
 * Model-View-Controller Pattern
 * 
 * The primary purpose of MVC is to separate responsibilities of individual
 * classes. This makes debugging, maintenance and expansion easier to implement.
 * 
 * The View generally includes the means of a user to interact with the program.
 * You'd initially think of this as a GUI, but think of it as something more 
 * abstract. A command line terminal would count as a View.
 * 
 * The Model represents your data stores, databases or resource allocation.
 * 
 * Note: There are many variations of MVC that all look alike but are named 
 * differently. An MVC implementation where the View and Model never interact 
 * is also known as;
 * - Model-View-Adapter, 
 * - Model-View-Mediating Controller or
 * - Model-View-Presenter.
 * 
 * In the above mentioned pattern the architecture looks like as follows:
 *     ______       ____________       _______
 *    |      | --> |            | --> |       |
 *    | View |     | Controller |     | Model |
 *    |______| <-- |____________| <-- |_______|
 * 
 * The View and Model are unaware of eachother's existence. Only the Controller
 * has a dependency of both. 
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
		new Controller(model, view);
		view.setVisible(true);
	}
}
