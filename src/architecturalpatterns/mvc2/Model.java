package architecturalpatterns.mvc2;

/*
 * data structure
 */
class Model
{
	private View view;
	private int result = 0;

	public Model(View v) 
	{
		view = v;
	}

	public void addition(int num1, int num2)
	{
		result = num1 + num2;
		setResult(result);
	}
	
	public void subtract(int num1, int num2)
	{
		result = num1 - num2;
		setResult(result);
	}
	
	public void setResult(int result)
	{
		view.setResult(""+result);
	}
}
