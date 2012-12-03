package main;

import view.MainWindow;
import model.maze.Maze;

public class Main {
	public static void main(String[] args) {
		Maze maze = new Maze();
		
		maze.initFromTextFile("data/labyrinthe1.txt");
		maze.solve();
		maze.saveToTextFile("data/labyrinthe2.txt");
		new MainWindow();
	}
}
