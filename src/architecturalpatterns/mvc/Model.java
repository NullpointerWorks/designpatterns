package architecturalpatterns.mvc;

import java.util.ArrayList;
import java.util.List;

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
