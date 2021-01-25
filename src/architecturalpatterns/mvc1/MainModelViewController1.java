package architecturalpatterns.mvc1;

/**
 * Model-View-Controller Pattern
 * 
 * The primary purpose of MVC is to separate responsibilities of individual
 * classes. This makes debugging, maintenance and expansion easier to implement.
 * This principle is better known as the Separation of Concerns (SoC) and also
 * complies with the single responsibility principle.
 * <br><br>
 * The View generally includes the methods with which a user can interact with 
 * the program. You'd initially think of this as a GUI, but think of it as 
 * something more abstract. A command line terminal would count as a View. 
 * <br><br>
 * The Model represents your data stores, databases or resource allocation. This
 * might contain some business logic, like data conversion and error handling.
 * <br><br>
 * The Controller is responsible with handling the interaction between the View 
 * and the Model. Keep in mind when the View grows in size so does the Controller, 
 * and when the Model grows in complexity so again does the Controller. This easily
 * makes the Controller the most complex system in your application. Splitting the 
 * Controller up in multiple classes reduces the odds of god-classes appearing in
 * your project. A way to accomplished this is using the Command Pattern. Each
 * interaction with the UI is coupled with its own command implementation object.
 * This breaks the Controller up in classes with their own responsibility.
 * <br><br>
 * Note: There are many variations of MVC that all look alike but are named 
 * differently. An MVC implementation where the View and Model never interact 
 * is also known as;<br>
 * - Model-View-Adapter, <br>
 * - Model-View-Mediating Controller or<br>
 * - Model-View-Presenter.<br>
 * <br>
 * In the above mentioned pattern the architecture looks like as follows:
 * <pre>
 *     ______       ____________       _______
 *    |      | --> |            | --> |       |
 *    | View |     | Controller |     | Model |
 *    |______| <-- |____________| <-- |_______|
 * </pre>
 * The View and Model are unaware of eachother's existence. The controller acts as
 * a mediator between the two. 
 * 
 * 
 * 
 * <br><br>
 */
public class MainModelViewController1
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		new Controller(model, view);
		view.setVisible(true);
	}
}
