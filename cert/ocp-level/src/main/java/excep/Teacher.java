package excep;

public class Teacher {
	public final static void main(String... students) {
		try {
			new Teacher().checkClasswork(10);
		} catch (Error e) {
			System.out.print("Bad idea");
			throw e;
		}
	}

	public int checkClasswork(int choices) {
		assert choices++ == 10 : 1;
		assert true != false : new StringBuilder("Answer2");
		assert (null == null) : new Object();
		assert ++choices == 11 : "Answer4";
		assert 2 == 3 : "";
		return choices;
	}
}