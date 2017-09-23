package exceptions.dispose;//: exceptions/exceptions.dispose.Cleanup.java
// Guaranteeing proper cleanup of a resource.

public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			try {
				String s;
				int i = 1;
				//noinspection StatementWithEmptyBody
				while ((s = in.getLine()) != null)
					; // Perform line-by-line processing here...
			} catch (Exception e) {
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("exceptions.InputFile construction failed");
		}
	}
}
/* Output: (if Cleanup.java is found)
dispose() successful
*///:~
