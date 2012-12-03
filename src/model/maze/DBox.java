package model.maze;

import java.awt.Color;
import java.awt.Graphics;

public class DBox extends MBox {

	public DBox(Maze maze, int line, int column) {
		super(maze, line, column);
	}

	public String toString() {
		return "D";
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(getColumn() * 10, getLine() * 10, 10, 10);		
	}
}
