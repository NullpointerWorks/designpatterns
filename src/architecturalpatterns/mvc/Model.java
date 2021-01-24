package architecturalpatterns.mvc;

/*
 * data structure
 * 
 * these represent dynamic data structures that make up the state of the application
 */
class Model
{
	private int result = 0;

	public void addition(int num1, int num2)
	{
		result = num1 + num2;
	}
	
	public void subtract(int num1, int num2)
	{
		result = num1 - num2;
	}
	
	public int getResult()
	{
		return result;
	}
}
