package model.maze;

import java.util.ArrayList;

import model.dijkstra.GraphInterface;
import model.dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private final MBox[][] boxes;
	
	public Maze() {
		boxes = new MBox[HEIGHT][WIDTH];
	}
	
	public final MBox getBox(int line, int column) {
		return boxes[line][column];
	}

	public final ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		for (int line = 0; line < HEIGHT; line ++) 
			for (int column = 0; column < WIDTH; column ++)
				allVertices.add(boxes[line][column]);
		return allVertices;
	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox) vertex;

		int line = box.getLine();
		int column = box.getColumn();
		
		if (line > 0) {
			MBox neighbor = boxes[line - 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		
		if (line < HEIGHT - 1) {
			MBox neighbor = boxes[line + 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		
		if (column > 0) {
			MBox neighbor = boxes[line][column - 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		
		if (column < WIDTH - 1) {
			MBox neighbor = boxes[line][column + 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}
		
		return successors;
	}

	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}
}