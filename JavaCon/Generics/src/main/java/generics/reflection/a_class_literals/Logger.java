package generics.reflection.a_class_literals;

public class Logger {
	private String value;

	public Logger(String value) {
		this.value = value;
	}

	void log() {
		System.out.println(value);
	}
}
