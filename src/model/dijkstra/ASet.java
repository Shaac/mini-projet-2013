package model.dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {

	private static final long serialVersionUID = 7151466803740300777L;

	public boolean contains(VertexInterface vertex) {
		return super.contains(vertex);
	}
}
