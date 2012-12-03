package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.maze.Maze;

public class Display extends JPanel implements Observer {

	private static final long serialVersionUID = -3031592359043728228L;
	private Maze maze;
	
	public Display(Maze maze) {
		this.maze = maze;
		setBackground(Color.WHITE) ;
		setPreferredSize(new Dimension(Maze.WIDTH * 10, Maze.HEIGHT * 10));
		maze.solve();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    maze.draw(g);
	}
		
	public void update(Observable o, Object arg) {
		repaint();
	}
}