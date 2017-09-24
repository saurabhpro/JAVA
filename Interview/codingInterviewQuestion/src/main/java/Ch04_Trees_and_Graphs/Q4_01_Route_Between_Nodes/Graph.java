package Ch04_Trees_and_Graphs.Q4_01_Route_Between_Nodes;

class Graph {
	private static final int MAX_VERTICES = 6;
	private final Node[] vertices;
	private int count;

	public Graph() {
		vertices = new Node[MAX_VERTICES];
		count = 0;
	}

	public void addNode(Node x) {
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
	}

	public Node[] getNodes() {
		return vertices;
	}
}

