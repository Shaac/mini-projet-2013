package model.maze;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.dijkstra.Dijkstra;
import model.dijkstra.GraphInterface;
import model.dijkstra.VertexInterface;
import model.maze.Box.Type;
import view.Graphic;

public class Maze implements GraphInterface, Graphic {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private final Box[][] boxes;
	private Box departure, arrival;

	public Maze() {
		boxes = new Box[HEIGHT][WIDTH];
	}

	public final Box getBox(int line, int column) {
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
		Box box = (Box) vertex;

		int line = box.getLine();
		int column = box.getColumn();

		if (line > 0) {
			Box neighbor = boxes[line - 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}

		if (line < HEIGHT - 1) {
			Box neighbor = boxes[line + 1][column];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}

		if (column > 0) {
			Box neighbor = boxes[line][column - 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}

		if (column < WIDTH - 1) {
			Box neighbor = boxes[line][column + 1];
			if (neighbor.isAccessible())
				successors.add(neighbor);
		}

		return successors;
	}

	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}

	public final void initFromTextFile(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			for (int lineNo = 0; lineNo < HEIGHT; lineNo ++) {
				String line = br.readLine();

				if (line == null)
					throw new MazeReadingException(fileName, lineNo, "not enought lines");
				if (line.length() < WIDTH)
					throw new MazeReadingException(fileName, lineNo, "line too short");
				if (line.length() > WIDTH)
					throw new MazeReadingException(fileName, lineNo, "line too long");

				for (int columnNo = 0; columnNo < WIDTH; columnNo ++)
					switch (line.charAt(columnNo)) {
					case 'D':
						boxes[lineNo][columnNo] = new Box(this, lineNo, columnNo, Type.DEPARTURE);
						departure = boxes[lineNo][columnNo];
						break;
					case 'A':
						boxes[lineNo][columnNo] = new Box(this, lineNo, columnNo, Type.ARRIVAL);
						arrival = boxes[lineNo][columnNo];
						break;
					case 'W':
						boxes[lineNo][columnNo] = new Box(this, lineNo, columnNo, Type.WALL);
						break;
					case 'E':
						boxes[lineNo][columnNo] = new Box(this, lineNo, columnNo, Type.EMPTY);
						break;
					default:
						throw new MazeReadingException(fileName, lineNo, "unknown character");
					}
			}

			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error from class Maze, initFromTextFile: file " + fileName + " not found.");
		} catch (IOException e) {
			System.err.println("Error from class Maze, initFromTextFile: read error on file " + fileName + ".");
		} catch (MazeReadingException e) {
			System.err.println(e.getMessage());
		}
	}

	public final void saveToTextFile(String fileName) {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(fileName);

			for (int lineNo = 0; lineNo < HEIGHT; lineNo ++) {
				for (int columnNo = 0; columnNo < WIDTH; columnNo ++)
					pw.print(boxes[lineNo][columnNo]);
				pw.println();
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error from class Maze, initFromTextFile: file " + fileName + " not found.");
		}
	}

	public void solve() {
		for (VertexInterface v : getAllVertices()) {
			((Box) v).setIsOnPath(false);
		}
		if (departure != null && arrival != null)
			for (VertexInterface v : Dijkstra.dijkstra(this, departure).getShortestPathTo(arrival))
				((Box) v).setIsOnPath(true);
	}

	public void draw(Graphics g) {
		for (VertexInterface v : getAllVertices())
			if (v != null)
				((Box) v).draw(g);	
	}

	public void switchBox(int column, int line) {
		boxes[line][column].switchBox();
	}

	public Box getDeparture() {
		return departure;
	}

	public Box getArrival() {
		return arrival;
	}

	public void setDeparture(Box departure) {
		this.departure = departure;
	}

	public void setArrival(Box arrival) {
		this.arrival = arrival;
	}
}