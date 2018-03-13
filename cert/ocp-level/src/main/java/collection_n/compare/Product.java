package collection_n.compare;

/**
 * The compareTo() and equals() methods are not consistent.
 */
public class Product implements Comparable<Product> {
	private int id;
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return this.id == other.id;
	}

	@Override
	public int compareTo(Product obj) {
		return this.name.compareTo(obj.name);
	}
}