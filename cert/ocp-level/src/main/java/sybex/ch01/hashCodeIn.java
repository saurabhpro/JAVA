package sybex.ch01;

public class hashCodeIn {
	private int i;
	private int j;

	public static void main(String[] args) {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		/*
		 * In the constructor, you make sure that neither instance variable is null.
		 * This check allows equals() to be simpler because you don’t have to worry about null there.
		 */
		if (o == null || getClass() != o.getClass()) return false;

		hashCodeIn that = (hashCodeIn) o;

		return (i == that.i);
	}

	/**
	 * hashCode should not have all elements - only those which remain constant for an object
	 * like name can be part of it but weight cannot since it will change more often
	 * <p>
	 * hashCode() can use a subset of the variables that equals() uses. - else it is considered illegal
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		return i + (j * 9);
	}
}


class Lion {
	private int age;
	private String name;
	private int idNumber;

	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Lion)) return false;
		Lion otherLion = (Lion) obj;
		return this.idNumber == otherLion.idNumber;
	}

	@Override
	public int hashCode() {
		return idNumber * 7 + age;  // no compiler error - but it is considered illegal - since it uses more variables than equals
	}
}
