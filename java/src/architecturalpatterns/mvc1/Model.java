package architecturalpatterns.mvc1;

/*
 * data structure
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
