package architecturalpatterns.mvc;

import java.awt.event.ActionListener;

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
