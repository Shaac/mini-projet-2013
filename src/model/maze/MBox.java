package model.maze;

import model.dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	private final Maze maze;
	private final int line;
	private final int column;
	
	public final String getLabel() {
		return "(" + line + "," + column + ")";
	}
	
	public MBox(Maze maze, int line, int column) {
		this.maze = maze;
		this.line = line;
		this.column = column;
	}
	
	public abstract String toString();
	
	public boolean isAccessible() {
		return true;
	}
	
	public final int getLine() {
		return line;
	}
	
	public final int getColumn() {
		return column;
	}
}