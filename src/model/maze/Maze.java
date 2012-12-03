package model.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.dijkstra.Dijkstra;
import model.dijkstra.GraphInterface;
import model.dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;

	private final MBox[][] boxes;
	private MBox depart, arrival;
	
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
						boxes[lineNo][columnNo] = new DBox(this, lineNo, columnNo);
						depart = boxes[lineNo][columnNo];
						break;
					case 'A':
						boxes[lineNo][columnNo] = new ABox(this, lineNo, columnNo);
						arrival = boxes[lineNo][columnNo];
						break;
					case 'W':
						boxes[lineNo][columnNo] = new WBox(this, lineNo, columnNo);
						break;
					case 'E':
						boxes[lineNo][columnNo] = new EBox(this, lineNo, columnNo);
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
		ArrayList<VertexInterface> a = Dijkstra.dijkstra(this, depart).getShortestPathTo(arrival);
		for (VertexInterface p : a)
			System.out.println(p.getLabel());
	}
}