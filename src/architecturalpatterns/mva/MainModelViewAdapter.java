package architecturalpatterns.mva;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Model-View-Adapter Pattern
 * 
 * Similar to MVC and MVP, this is another approach to separate the front-end from 
 * the back-end. The aim of MVA is to entirely decoupling the Model and View making 
 * sure all interaction is done through the Adapter class. 
 * 
 * Note: the MVA adapter class is not related to the Adapter Pattern
 * 
 * 
 */
public class MainModelViewAdapter
{
	public static void main(String[] args)
	{
		// make the model and view, they do not know of each other
		Model model = new Model();
		View view = new View();
		
		// make the adapter controlling a model and view object
		Adapter adapter = new Adapter(model, view);
		adapter.setInput( "Hello world!" );
		adapter.setInput( "This is a MVA test." );
		adapter.updateView();
	}
}

/*
 * data structure
 * 
 * these represent dynamic data structures that make up the state of the application
 */
class Model
{
	private List<String> data = new ArrayList<String>();
	
	public boolean hasData()
	{
		return data.size() > 0;
	}
	
	public void pushData(String msg)
	{
		data.add(msg);
	}
	
	public String popData()
	{
		return data.remove(0);
	}
}

/*
 * front-end
 * 
 * this could be a display or UI
 */
class View
{
	private ActionListener alStore = (e)->
	{
		
	};
	
	private ActionListener alPrint = (e)->
	{
		
	};
	
	public View()
	{
		JTextArea textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setSize(100,30);
		textarea.setPreferredSize(textarea.getSize());

		JButton button = new JButton();
		button.setText("Store");
		button.addActionListener(alStore);
		button.setSize(100,60);
		button.setPreferredSize(button.getSize());
		
		JButton print = new JButton();
		print.setText("Print");
		print.addActionListener(alPrint);
		print.setSize(100,60);
		print.setPreferredSize(print.getSize());
		
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		panel.setLayout( new GridBagLayout() );
		panel.setSize(320,240);
		panel.setPreferredSize(panel.getSize());
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 2;
	    gbc.gridwidth = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
		panel.add(textarea, gbc);
		
		gbc.gridx = 1;
	    gbc.gridheight = 1;
		panel.add(button, gbc);
		
	    gbc.gridy = 1;
		panel.add(print, gbc);
		
		JFrame window = new JFrame();
		window.add(panel);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void showConsoleData(String[] msg)
	{
		for (String s : msg) showConsoleData(s);
	}
	
	public void showConsoleData(String msg)
	{
		System.out.println(msg);
	}
}

/*
 * a.k.a. "mediating controller" between the interface and data
 */
class Adapter
{
	private Model model;
	private View view;
	
	public Adapter(Model m, View v)
	{
		model = m;
		view = v;
	}
	
	public void setInput(String data)
	{
		model.pushData(data);
	}
	
	public void updateView()
	{
		while (model.hasData())
		{
			view.showConsoleData( model.popData() );
		}
	}
}
