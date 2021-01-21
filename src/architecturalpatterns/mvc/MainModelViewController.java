package architecturalpatterns.mvc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


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

		model.attach(view);
		
		
	}
}

/*
 * data structures
 * database
 */
class Model
{
	private List<View> views = new ArrayList<View>();
	private List<String> data = new ArrayList<String>();
	
	public void attach(View v) 
	{
		if (!views.contains(v)) views.add(v);
	}
	
	public void detach(View v) 
	{
		if (views.contains(v)) views.remove(v);
	}
	
	public void update()
	{
		for (View v : views)
		{
			v.update();
		}
	}
	
	public void addData(String d) 
	{
		data.add(d);
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
	
	private ActionListener alStore = (e)->
	{
		
	};
	
	private ActionListener alPrint = (e)->
	{
		
	};
	
	public View()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public void printDataToConsole(String msg)
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
