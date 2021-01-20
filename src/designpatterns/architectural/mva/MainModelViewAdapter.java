package designpatterns.architectural.mva;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-View-Adapter Pattern
 * 
 * Similar to MVC and MVP, this is another approach to separate the front-end from 
 * the back-end. The aim of MVA is to entirely decoupling the Model and View objects 
 * so that all interaction is done through the Adapter class.
 * 
 * Note: the MVA adapter class is not related to the Adapter Pattern
 * 
 * 
 */
public class MainModelViewAdapter
{
	public static void main(String[] args)
	{
		// make the model and view, they do not know of each other
		Model model = new Model();
		View view = new View();
		
		// make the adapter controlling a model and view object
		Adapter adapter = new Adapter(model, view);
		adapter.setInput( "Hello world!" );
		adapter.setInput( "This is a MVA test." );
		adapter.updateView();
	}
}

/*
 * back-end
 * 
 * these represent dynamic data structures that make up the state of the application
 */
class Model
{
	private List<String> data = new ArrayList<String>();
	
	public boolean hasData()
	{
		return data.size() > 0;
	}
	
	public void pushData(String msg)
	{
		data.add(msg);
	}
	
	public String popData()
	{
		return data.remove(0);
	}
}

/*
 * front-end
 * 
 * this could be a display or UI
 */
class View
{
	public void showConsoleData(String[] msg)
	{
		for (String s : msg) showConsoleData(s);
	}
	
	public void showConsoleData(String msg)
	{
		System.out.println(msg);
	}
}

/*
 * mediator between front- and back-end
 */
class Adapter
{
	private Model model;
	private View view;
	
	public Adapter(Model m, View v)
	{
		model = m;
		view = v;
	}
	
	public void setInput(String data)
	{
		model.pushData(data);
	}
	
	public void updateView()
	{
		while (model.hasData())
		{
			view.showConsoleData( model.popData() );
		}
	}
}
