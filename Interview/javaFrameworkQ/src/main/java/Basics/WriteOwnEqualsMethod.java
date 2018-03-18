package Basics;

public class WriteOwnEqualsMethod {

	private int id;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		WriteOwnEqualsMethod equals = (WriteOwnEqualsMethod) o;

		return id == equals.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
