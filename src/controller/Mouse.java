package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.maze.Box;

import view.Display;

/**
 * The Mouse Listener.
 *
 * @author Shaac
 */
public class Mouse implements MouseListener {
	
    /**
     * The JPanel that displays the maze.
     */
	private Display display;
	
    /**
     * Constructs the mouse listener.
     *
     * @param display the JPanl that displays the maze.
     */
	public Mouse(Display display) {
		this.display = display;
    }
	
    /**
     * Called each time the mouse is clicked.
     *
     * @param m information about the event.
     */
	public void mouseClicked(MouseEvent m) {
        int size = Box.size;
		display.switchBox((int) (m.getX() / size), (int) (m.getY() / size));
	}
	
    /**
     * Called each time the mouse is clicked. Not Used.
     *
     * @param m information about the event.
     */
	public void mouseEntered(MouseEvent m) {}

    /**
     * Called each time the mouse is clicked. Not Used.
     *
     * @param m information about the event.
     */
	public void mouseExited(MouseEvent m) {}

    /**
     * Called each time the mouse is clicked. Not Used.
     *
     * @param m information about the event.
     */
	public void mousePressed(MouseEvent m) {}

    /**
     * Called each time the mouse is clicked. Not Used.
     *
     * @param m information about the event.
     */
	public void mouseReleased(MouseEvent m) {}

    /**
     * Called each time the mouse is clicked. Not Used.
     *
     * @param m information about the event.
     */
	public void mouseDragged(MouseEvent m) {}
}
