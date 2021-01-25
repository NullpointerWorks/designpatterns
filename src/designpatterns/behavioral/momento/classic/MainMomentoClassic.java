package designpatterns.behavioral.momento.classic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Momento Pattern
 * 
 * The classic momento pattern is implemented using nested classes. Not 
 * all programming languages have this capability. Among those that can;
 * <pre>
 * - C++
 * - C#
 * - D
 * - Java
 * - VB.NET
 * </pre>
 * 
 */
public class MainMomentoClassic 
{
	public static void main(String[] args) 
	{
		History history = new History();
		
		MomentoJTextArea textarea = new MomentoJTextArea();
		textarea.setSize(140,170);
		textarea.setPreferredSize(textarea.getSize());
		textarea.setWrapStyleWord(true);
		textarea.setLineWrap(true);
		history.push( textarea.getSnapshot() ); // set initial state
		
		JButton button1 = new JButton();
		button1.setText("Save Snapshot");
		button1.setSize(140,24);
		button1.setPreferredSize(button1.getSize());
		button1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				history.push( textarea.getSnapshot() );
			}
		});
		
		JButton button2 = new JButton();
		button2.setText("Restore");
		button2.setSize(140,24);
		button2.setPreferredSize(button2.getSize());
		button2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				history.pop().restore();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setSize(160,240);
		panel.setPreferredSize(panel.getSize());
		panel.add(textarea);
		panel.add(button1);
		panel.add(button2);
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.validate();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/*
 * momento caretaker
 */
class History
{
	private List<Momento> h;
	
	public History()
	{
		h = new ArrayList<Momento>();
	}
	
	public void push(Momento m)
	{
		h.add(0,m);
	}
	
	public Momento pop()
	{
		// if no momento's are stored, return a default null object
		if (h.size()==0) return new Momento() {public void restore(){}};
		return h.remove(0);
	}
}

/*
 * create a momento interface with limited methods. whichever you include, it 
 * should not expose the private state of the momento.
 */
interface Momento
{
	void restore();
}

class MomentoJTextArea extends JTextArea
{
	private static final long serialVersionUID = 5097679541077642517L;
	
	public Momento getSnapshot()
	{
		String text = this.getText();
		return new Snapshot(text);
	}
	
	/*
	 * nested momento class which has access to the textfield's private state
	 */
	private class Snapshot implements Momento
	{
		private String text;
		public Snapshot(String t) 
		{
			text = t;
		}
		
		@Override
		public void restore() 
		{
			setText(text);
		}
	}
}
