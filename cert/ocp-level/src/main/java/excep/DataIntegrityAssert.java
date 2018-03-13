package excep;

public class DataIntegrityAssert {
	private int score;

	public DataIntegrityAssert() {
		super();
		DataIntegrityAssert.this.score = 5;   // ok
	}

	public static void main(String[] books) {
		final DataIntegrityAssert johnny5 = new DataIntegrityAssert();

		// “ The optional second parameter of an assert statement, when used, must return a value.”

		assert (johnny5.score > 2) : johnny5.score++;
		assert johnny5.score >= 5 : "No input";
		// assert "p".equals("") : (a) -> "Oops";  // lambda not expected
		System.out.print("Made it!");
	}
}
