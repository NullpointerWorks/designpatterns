package architecturalpatterns.mvc;

/*
 * business logic
 * back-end
 */
class Controller
{
	private Model model;
	private View view;
	
	public void setDependency(Model m, View v)
	{
		model = m;
		view = v;
	}
	
	
	
	
}
