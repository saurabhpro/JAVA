package references;

class SuperString {
	public String toString() {
		return "Super String";
	}

	public Object toString(String str) {
		return "Super " + str;
	}
}

class SubString extends SuperString {
	public String toString() {
		return "Sub String";
	}

	public String toString(String str) {
		return "Sub " + str;
	}
}