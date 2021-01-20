package designpatterns.architectural.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-View-Controller Pattern
 * 
 * An architectural pattern to help separate UI code from the back-end code. 
 * The user interacts with the controller which updates the Model which in 
 * turn updates the View. 
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
		
		ctrl.setModel(model);
		model.setView(view);
		view.setController(ctrl);
		
		
	}
}

/*
 * data structures
 * database
 */
class Model
{
	private View view;
	private List<String> data = new ArrayList<String>();

	public void setView(View v) 
	{
		view = v;
	}
	
	
}

/*
 * display
 * UI
 * front-end
 */
class View
{
	private Controller ctrl;
	
	public void showConsoleData(String msg)
	{
		System.out.println(msg);
	}

	public void setController(Controller c) 
	{
		ctrl = c;
	}
}

/*
 * business logic
 * back-end
 */
class Controller
{
	private Model model;
	
	public void setModel(Model m) 
	{
		model = m;
	}
	
}
