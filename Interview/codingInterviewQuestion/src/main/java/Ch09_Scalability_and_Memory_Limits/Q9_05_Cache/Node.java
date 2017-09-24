package Ch09_Scalability_and_Memory_Limits.Q9_05_Cache;

public class Node {
	public final String query;
	public Node prev;
	public Node next;
	public String[] results;

	public Node(String q, String[] res) {
		results = res;
		query = q;
	}
}