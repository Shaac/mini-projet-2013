package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Display;

public class Mouse implements MouseListener {
	
	private Display display;
	
	public Mouse(Display display) {
		this.display = display;
    }
	
	public void mouseClicked(MouseEvent e) {
		display.switchBox((int) (e.getX()/10), (int) (e.getY()/10));
	}
	
	public void mouseEntered(MouseEvent m) {}

	public void mouseExited(MouseEvent m) {}

	public void mousePressed(MouseEvent m) {}

	public void mouseReleased(MouseEvent m) {}

	public void mouseDragged(MouseEvent m) {}
}