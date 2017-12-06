package references;

abstract class Book {
	protected static String material = "papyrus";
	private int a = 5;

	public Book() {
	}

	public Book(String material) {
		this.material = material;
	}
}

class Encyclopedia extends Book {
	public static String material = "cellulose";
	private int a = 6;

	public Encyclopedia() {
		super();
	}

	public static void main(String[] pages) {
		System.out.print(new Encyclopedia().getMaterial());

		Book b = new Encyclopedia();
		//	System.out.println(b.a); not allowed
	}

	public String getMaterial() {
		return super.material;
	}
}