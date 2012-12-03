package view;

import javax.swing.JFrame;

import model.maze.Maze;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 3172688540921699213L;
	
	public MainWindow(Maze maze) {
		super("Maze");
		setContentPane(new Display(maze));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
