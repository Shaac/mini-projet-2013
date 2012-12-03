package model.maze;

import java.awt.Color;
import java.awt.Graphics;

public class ABox extends MBox {

	public ABox(Maze maze, int line, int column) {
		super(maze, line, column);
	}

	public String toString() {
		return "A";
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(getColumn() * 10, getLine() * 10, 10, 10);		
	}
}
