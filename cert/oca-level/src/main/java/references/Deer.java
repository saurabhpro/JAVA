package references;

public class Deer {
	Deer() {
		System.out.print("Deer");
	}

	public Deer(int age) {
		System.out.print("DeerAge");
	}

	public static void main(String[] args) {

		Deer deer = new Reindeer(5);
		System.out.println("," + deer.hasHorns());
	}

	private boolean hasHorns() {
		return false;
	}
}

class Reindeer extends Deer {
	Reindeer(int age) {
		System.out.print("Reindeer");
	}

	public boolean hasHorns() {
		return true;
	}


}