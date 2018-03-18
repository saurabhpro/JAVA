/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package map.pluralsight;

class BadHash {
	private final String value;
	private final int hash;

	public BadHash(final String value, final int hash) {
		this.value = value;
		this.hash = hash;
	}

	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final BadHash badHash = (BadHash) o;

		return value.equals(badHash.value);
	}

	public int hashCode() {
		return hash;
	}

	public String toString() {
		return "[" + value + ": " + hash + ']';
	}
}
