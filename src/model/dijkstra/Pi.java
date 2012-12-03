package model.dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Integer>
	implements PiInterface {

	private static final long serialVersionUID = -1117363279073800384L;

	public void setValue(VertexInterface vertex, int value) {
		put(vertex, new Integer(value));		
	}

	public int getValue(VertexInterface vertex) {
		return get(vertex).intValue();
	}

}
