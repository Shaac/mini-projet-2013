package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.Display;

/**
 * The listener for the save button.
 *
 * @author Shaac
 */
public class SaveListener implements ActionListener {

    /**
     * The JPanel that displays the maze.
     */
    private Display display;

    /**
     * Constructs the listener for the save button.
     *
     * @param display the JPanel that displays the maze.
     */
    public SaveListener(Display display) {
        this.display = display;
    }

    /**
     * Called each time the listened button is pressed.
     *
     * @param arg0 information about the event.
     */
    public void actionPerformed(ActionEvent arg0) {

        // We ask for the output file:
        JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
        dialog.showOpenDialog(null);

        if (dialog.getSelectedFile() != null)
            // We save the maze:
            display.getMaze().saveToTextFile(
                    dialog.getSelectedFile().getAbsolutePath());
    }
}
