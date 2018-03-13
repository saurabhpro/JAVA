package class_design;

public class Rodent {
}

class Capybara extends Rodent {
	public static void main(String[] args) {

		// ok
		Rodent rodent1 = new Capybara();
		Capybara capybara1 = (Capybara) rodent1;
		System.out.println("ok");

		// not ok
		Rodent rodent = new Rodent();
		Capybara capybara = (Capybara) rodent; // Throws ClassCastException at runtime

		// ok
		Capybara capybara2 = new Capybara();
		Rodent rodent2 = (Rodent) capybara2;
	}
}