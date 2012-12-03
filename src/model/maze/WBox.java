package model.maze;

import java.awt.Color;
import java.awt.Graphics;

public class WBox extends MBox {

	public WBox(Maze maze, int line, int column) {
		super(maze, line, column);
	}

	@Override
	public boolean isAccessible() {
		return false;
	}
	
	public String toString() {
		return "W";
	}
	
	public void draw(Graphics g) {
	g.setColor(Color.BLACK);
		g.fillRect(getColumn() * 10, getLine() * 10, 10, 10);		
	}
}
