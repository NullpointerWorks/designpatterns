package designpatterns.behavioral.responsibilitychain;

/**
 * Chain Of Responsibility
 * 
 * 
 */
public class ChainOfResponsibility 
{
	public static void main(String[] args)
	{
		RequestHandler h1 = new LengthHandler();
		RequestHandler h2 = new NotANumberHandler();
		RequestHandler h3 = new PrinterHandler();
		
		h1.setNext(h2);
		h2.setNext(h3);
		
		// this request gets kicked out at 'h2'
		h1.execute("0123456789");
		
		// this request gets printed
		h1.execute("Hello World!");
	}
}

interface RequestHandler
{
	void setNext(RequestHandler r);
	void execute(String requestData);
}

class LengthHandler implements RequestHandler
{
	private RequestHandler next;
	
	@Override
	public void execute(String rd) 
	{
		if (rd.length() < 5) return;
		if (next!=null) next.execute(rd);
	}

	@Override
	public void setNext(RequestHandler r) 
	{
		next = r;
	}
}

class NotANumberHandler implements RequestHandler
{
	private RequestHandler next;
	
	@Override
	public void execute(String rd) 
	{
		if (rd.matches("[0-9]+")) return;
		if (next!=null) next.execute(rd);
	}

	@Override
	public void setNext(RequestHandler r) 
	{
		next = r;
	}
}

class PrinterHandler implements RequestHandler
{
	private RequestHandler next;
	
	@Override
	public void execute(String rd) 
	{
		System.out.println(rd);
		if (next!=null) next.execute(rd);
	}

	@Override
	public void setNext(RequestHandler r) 
	{
		next = r;
	}
}
