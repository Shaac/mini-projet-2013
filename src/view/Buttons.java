package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.LoadListener;
import controller.SaveListener;

public class Buttons extends JPanel {
	
	/**
	 * A generated serial version ID.
	 */
	private static final long serialVersionUID = 4775927704663902700L;
	
	public Buttons(Display display) {
		
		setLayout(new GridLayout(1,3)) ;
		
		JButton load = new JButton("Load");
		load.addActionListener(new LoadListener(display));
		add(load);
		
		JButton save = new JButton("Save");
		save.addActionListener(new SaveListener(display));
		add(save);
		
		JButton clean = new JButton("Clean");
		add(clean);
	}
}
