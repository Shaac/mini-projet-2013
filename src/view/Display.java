package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.maze.Maze;

public class Display extends JPanel {

	private static final long serialVersionUID = -3031592359043728228L;
	private Maze maze;
	
	public Display() {
		maze = new Maze();
		setBackground(Color.WHITE) ;
		setPreferredSize(new Dimension(Maze.WIDTH * 10, Maze.HEIGHT * 10));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    maze.draw(g);
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
		maze.solve();
		repaint();
	}
	
	public void switchBox(int column, int line) {
		maze.switchBox(column, line);
		maze.solve();
		repaint();
	}
}