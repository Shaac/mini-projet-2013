package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Mouse;

/**
 * This is the Frame that contains everything.
 * 
 * @author Shaac
 */
public class MainWindow extends JFrame {

	/**
	 * A generated serial version ID. 
	 */
	private static final long serialVersionUID = 3172688540921699213L;

	/**
	 * Creates the main Window.
	 */
	public MainWindow() {
		
		// Set the title:
		super("Maze");
		
		// Create the display zone for the maze:
		Display display = new Display();
		
		// Display the buttons:
		Buttons buttons = new Buttons(display);
		
		addMouseListener(new Mouse(display));
		
		// Build the window:
		add(display, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		
		// The window is ready to be displayed:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
