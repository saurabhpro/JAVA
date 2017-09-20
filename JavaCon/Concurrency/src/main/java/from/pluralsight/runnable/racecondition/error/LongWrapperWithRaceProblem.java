package from.pluralsight.runnable.racecondition.error;

public class LongWrapperWithRaceProblem {

	private long l;

	public LongWrapperWithRaceProblem(long l) {
		this.l = l;
	}

	public long getValue() {

		return l;

	}

	public void incrementValue() {

		l = l + 1;

	}
}
