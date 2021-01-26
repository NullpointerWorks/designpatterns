package designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor Pattern
 * 
 * This pattern lets you separate an algorithm from the affected class. Think
 * of this pattern as an expansion on the Command pattern. It also has some
 * likeness to the Template pattern except from having a final template method
 * and a specific order of operations.
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
		
		Visitor notify = new TourVisitor();
		Visitor export = new XMLExportVisitor();
		
		zones.checkZones(notify);
		zones.checkZones(export);
		
	}
}

/*
 * Define a visitor interface that includes methods for handling different 
 * class signatures and create a concrete visitor to act on it. In this
 * example I've added a printing and XML visitor to demonstrate versatility.
 */
interface Visitor
{
	void onBegin();
	void onResidental(Residental r);
	void onIndustrial(Industrial i);
	void onCommercial(Commercial c);
	void onRecreation(Recreation r);
	void onEnd();
}

class TourVisitor implements Visitor
{
	@Override
	public void onBegin() 
	{
		System.out.println( "Let's go on a tour!" );
	}
	
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
	
	@Override
	public void onEnd() 
	{
		System.out.println( "And that wraps it up." );
	}
}

class XMLExportVisitor implements Visitor
{
	@Override
	public void onBegin() 
	{
		System.out.println("<city>");
		System.out.println("    <zones>");
	}
	
	@Override
	public void onResidental(Residental r) 
	{
		System.out.println("        <residental>");
		System.out.println("            "+r.getStyle() );
		System.out.println("        </residental>");
	}
	
	@Override
	public void onIndustrial(Industrial i) 
	{
		System.out.println("        <industry>");
		System.out.println("            "+i.getManufacturing() );
		System.out.println("        </industry>");
	}
	
	@Override
	public void onCommercial(Commercial c) 
	{
		System.out.println("        <commerce>");
		System.out.println("            "+c.getStreet() );
		System.out.println("        </commerce>");
	}
	
	@Override
	public void onRecreation(Recreation r) 
	{
		System.out.println("        <recreation>");
		System.out.println("            "+r.getLayout() );
		System.out.println("        </recreation>");
	}
	
	@Override
	public void onEnd() 
	{
		System.out.println("    </zones>");
		System.out.println("</city>");
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
		v.onBegin();
		for (Zone z : zones)
		{
			z.accept(v);
		}
		v.onEnd();
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
