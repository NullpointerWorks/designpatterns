package architecturalpatterns.mvc;

/*
 * data structures
 * database
 */
class Model
{
	private View view;
	
	public void setDependency(View v)
	{
		view = v;
	}
	
}
