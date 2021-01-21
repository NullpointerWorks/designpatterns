package designpatterns.architectural.mvc;

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
 * Model-View-Controller Pattern
 * 
 * An architectural pattern to help separate UI code from the back-end code. 
 * The user interacts with the controller which updates the Model which in 
 * turn updates the View. The structure has a triangular relationship in 
 * which the controller does not know about view, but knows how to access
 * the model. 
 * 
 * Unlike in MVA, this pattern allows for communication among the view and 
 * the model keeping the controller unaware. 
 * 
 * The View is responsible for displaying information, but may also take some 
 * user input, like pressing buttons, checkboxes and fields. Though input
 * may also take the form of a USB device which bypasses the UI.
 * 
 * 
 * 
 * 
 */
public class MainModelViewController
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Controller ctrl = new Controller();
		
		ctrl.setModel(model);
		model.setView(view);
		view.setController(ctrl);
		
		
		
	}
}

/*
 * data structures
 * database
 */
class Model
{
	private View view;
	private List<String> data = new ArrayList<String>();
	
	public void setView(View v) 
	{
		view = v;
	}

	public void setNewData(String d) 
	{
		data.add(d);
	}
}

/*
 * display
 * UI
 * front-end
 */
class View
{
	private Controller ctrl;
	
	private ActionListener alStore = (e)->
	{
		// send a command to the controller to store data
		var txtarea = (JTextArea)e.getSource();
		ctrl.pushCommand( new StoreCommand(txtarea) );
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
	
	public void printDataToConsole(String msg)
	{
		System.out.println(msg);
	}
	
	public void setController(Controller c) 
	{
		ctrl = c;
	}
	
}

/*
 * business logic
 * back-end
 */
class Controller
{
	private Model model;
	
	public void setModel(Model m) 
	{
		model = m;
	}
	
	public void pushCommand(Command cmd)
	{
		
		
		
	}
	
}

/*
 * Command Pattern
 * 
 * I'm adding this to encapsulate business logic into discrete classes
 * as to separate responsibility and decouple dependencies. This example
 * doesn't use a command history.
 * 
 */
interface Command
{
	void execute();
}

class PrintCommand implements Command
{
	@Override
	public void execute() 
	{
		
	}
}

class StoreCommand implements Command
{
	private String data = "";
	
	public StoreCommand() {}
	public StoreCommand(JTextArea ta) 
	{
		data = ta.getText();
	}
	
	@Override
	public void execute() 
	{
		//model.setNewData(data);
	}
}
