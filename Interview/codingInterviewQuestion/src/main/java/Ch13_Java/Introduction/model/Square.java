package Ch13_Java.Introduction.model;

@SuppressWarnings("unused")
public class Square implements Shape {
	@SuppressWarnings("FieldCanBeLocal")
	private final double len = 5;

	public void printMe() {
		System.out.println("I am a square.");
	}

	public double computeArea() {
		return len * len;
	}
}
