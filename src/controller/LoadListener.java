package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import model.maze.Maze;

import view.Display;

/**
 * The listener for the load button.
 *
 * @author Shaac
 */
public class LoadListener implements ActionListener {

    /**
     * The JPanel that displays the maze.
     */
    private Display display;

    /**
     * Constructs the listener for the load button.
     *
     * @param display the JPanel that displays the maze.
     */
    public LoadListener(Display display) {
        this.display = display;
    }

    /**
     * Called each time the listened button is pressed.
     *
     * @param arg0 information about the event.
     */
    public void actionPerformed(ActionEvent arg0) {

        // We ask for the input file:
        JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
        dialog.showOpenDialog(null);

        if (dialog.getSelectedFile() != null) {
            // We build a new Maze:
            Maze maze = new Maze();
            maze.initFromTextFile(dialog.getSelectedFile().getAbsolutePath());

            // We display it:
            display.setMaze(maze);
        }
    }
}
