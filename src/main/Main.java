package main;

import model.maze.Maze;

public class Main {
	public static void main(String[] args) {
		new Maze().initFromTextFile("data/labyrinthe1.txt");
	}
}
