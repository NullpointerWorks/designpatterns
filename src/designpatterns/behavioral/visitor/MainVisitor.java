package designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor Pattern
 * 
 * 
 * 
 */
public class MainVisitor 
{
	public static void main(String[] args) 
	{
		CityZones zones = new CityZones();
		zones.addZone( new Residental() );
		zones.addZone( new Industrial() );
		zones.addZone( new Commercial() );
		zones.addZone( new Recreation() );
		
		Visitor notify = new PrintVisitor();
		zones.checkZones(notify);
		
	}
}

/*
 * Define a visitor interface that includes methods for handling different 
 * class signatures and create a concrete visitor to act on it.
 */
interface Visitor
{
	void onResidental(Residental r);
	void onIndustrial(Industrial i);
	void onCommercial(Commercial c);
	void onRecreation(Recreation r);
}

class PrintVisitor implements Visitor
{
	@Override
	public void onResidental(Residental r) 
	{
		System.out.println( r.getStyle() );
	}
	
	@Override
	public void onIndustrial(Industrial i) 
	{
		System.out.println( i.getManufacturing() );
	}
	
	@Override
	public void onCommercial(Commercial c) 
	{
		System.out.println( c.getStreet() );
	}
	
	@Override
	public void onRecreation(Recreation r) 
	{
		System.out.println( r.getLayout() );
	}
}

/*
 * create a class which contains objects that can be acted upon by a visitor
 */
class CityZones
{
	private List<Zone> zones = new ArrayList<Zone>();
	
	public void addZone(Zone z)
	{
		if (!zones.contains(z)) zones.add(z);
	}
	
	public void checkZones(Visitor v)
	{
		for (Zone z : zones)
		{
			z.accept(v);
		}
	}
}

/*
 * defined an interface to let all subject classes implement an "accept()" 
 * method on which he visitor acts.
 * 
 * An important note is that all implementing classes have fields or methods 
 * specific for it's implementation. This way I demonstrate these classes to 
 * be distinct and not sharing any additional abstraction.
 */
interface Zone
{
	void accept(Visitor v);
}

class Residental implements Zone
{
	public String getStyle()
	{
		return "Victorial styled houses";
	}
	
	@Override
	public void accept(Visitor v)
	{
		v.onResidental(this);
	}
}

class Industrial implements Zone
{
	public String getManufacturing()
	{
		return "Produces lots of electronics";
	}
	
	@Override
	public void accept(Visitor v)
	{
		v.onIndustrial(this);
	}
}

class Commercial implements Zone
{
	public String getStreet()
	{
		return "Has shops and cafes";
	}
	
	@Override
	public void accept(Visitor v)
	{
		v.onCommercial(this);
	}
}

class Recreation implements Zone
{
	public String getLayout()
	{
		return "A zen garden with some cherry trees in blossom";
	}
	
	@Override
	public void accept(Visitor v)
	{
		v.onRecreation(this);
	}
}
