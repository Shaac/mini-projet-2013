package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.Display;

public class SaveListener implements ActionListener {
	
	private Display display;
	
	public SaveListener(Display display) {
		this.display = display;
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
        dialog.showOpenDialog(null);
        display.getMaze().saveToTextFile(dialog.getSelectedFile().getAbsolutePath());
	}
}
