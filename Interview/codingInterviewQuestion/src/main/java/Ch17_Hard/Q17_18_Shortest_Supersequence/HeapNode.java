package Ch17_Hard.Q17_18_Shortest_Supersequence;

class HeapNode implements Comparable<HeapNode> {
	public final int listId;
	public int locationWithinList;

	public HeapNode(int location, int list) {
		locationWithinList = location;
		listId = list;
	}

	@Override
	public int compareTo(HeapNode n) {
		return locationWithinList - n.locationWithinList;
	}
}
