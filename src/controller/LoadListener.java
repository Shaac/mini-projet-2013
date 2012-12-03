package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import model.maze.Maze;

import view.Display;

public class LoadListener implements ActionListener {
	
	private Display display;
	
	public LoadListener(Display display) {
		this.display = display;
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
        dialog.showOpenDialog(null);
        Maze maze = new Maze();
        maze.initFromTextFile(dialog.getSelectedFile().getAbsolutePath());
        display.setMaze(maze);
	}
}
