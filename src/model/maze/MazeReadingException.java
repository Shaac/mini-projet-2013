package model.maze;

public class MazeReadingException extends Exception {

	private static final long serialVersionUID = -1921966224026469563L;
	
	public MazeReadingException(String fileName, int lineNo, String errorMsg) {
		super("Error while reading Maze in " + fileName + "(" + lineNo + ")" + errorMsg);
	}
}
