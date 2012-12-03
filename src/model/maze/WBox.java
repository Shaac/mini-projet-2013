package model.maze;

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
}
