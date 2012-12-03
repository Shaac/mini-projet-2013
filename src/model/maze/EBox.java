package model.maze;

import java.awt.Color;
import java.awt.Graphics;

public class EBox extends MBox {

	public EBox(Maze maze, int line, int column) {
		super(maze, line, column);
	}

	public String toString() {
		return "E";
	}
	
	public void draw(Graphics g) {
		if (getIsOnPath())
			g.setColor(Color.RED);
		else
			g.setColor(Color.WHITE);
		g.fillRect(getColumn() * 10, getLine() * 10, 10, 10);		
	}
}
