package model.maze;

import java.awt.Color;
import java.awt.Graphics;

import view.Graphic;
import model.dijkstra.VertexInterface;

public class Box implements VertexInterface, Graphic {
    public static int size = 10;
	public enum Type {WALL, EMPTY, DEPARTURE, ARRIVAL};
	private final Maze maze;
	private Type type;
	private final int line;
	private final int column;
	private boolean isOnPath = false;

	public final String getLabel() {
		return "(" + line + "," + column + ")";
	}

	public Box(Maze maze, int line, int column, Type type) {
		this.maze = maze;
		this.line = line;
		this.column = column;
		this.type = type;
	}

	public String toString() {
		switch (type) {
		case WALL:
			return "W";
		case EMPTY:
			return "E";
		case DEPARTURE:
			return "D";
		case ARRIVAL:
			return "A";
		default:
			return "?";
		}
	}

	public boolean isAccessible() {
		return type != Type.WALL;
	}

	public final int getLine() {
		return line;
	}

	public final int getColumn() {
		return column;
	}

	public final void setIsOnPath(boolean b) {
		isOnPath = b;
	}

	public final boolean getIsOnPath() {
		return isOnPath;
	}

	public void switchBox() {
		if (type == Type.ARRIVAL)
			maze.setArrival(null);
		if (type == Type.DEPARTURE)
			maze.setDeparture(null);

		switch (type) {
		case WALL:
			type = Type.EMPTY;
			break;
		case EMPTY:
			if (maze.getDeparture() == null) {
				type = Type.DEPARTURE;
				maze.setDeparture(this);
				break;
			}
		case DEPARTURE:
			if (maze.getArrival() == null) {
				type = Type.ARRIVAL;
				maze.setArrival(this);
				break;
			}
		case ARRIVAL:
			type = Type.WALL;
		}
	}

	public void draw(Graphics g) {
		switch (type) {
		case WALL:
			g.setColor(Color.GRAY);
			break;
		case EMPTY:
			if (isOnPath)
				g.setColor(Color.RED);
			else
				g.setColor(Color.WHITE);
			break;
		case DEPARTURE:
			g.setColor(Color.BLUE);
			break;
		case ARRIVAL:
			g.setColor(Color.GREEN);
		}
		g.fillRect(column * 10, line * 10, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRect(column * 10, line * 10, 10, 10);
	}
}
