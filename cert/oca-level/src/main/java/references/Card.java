package references;

public interface Card {
}

abstract class PlayingCard implements Card {
}

class PokerCard extends PlayingCard {
}

class FlashCard implements Card {
}

class NoteCard implements Card {
}

class Game {
	public static void main(String[] args) {
		//insert code here
		Card c = new PokerCard();
		System.out.println((c instanceof Card) ? "Card!" : "Not Card?");
		System.out.println((c instanceof PlayingCard) ? "PlayingCard!" : "Not PlayingCard?");
		System.out.println((c instanceof FlashCard) ? "FlashCard!" : "Not FlashCard?");
		System.out.println((c instanceof NoteCard) ? "NoteCard!" : "Not NoteCard?");


		//Given the code fragment:

		char[] charArray = {'e', 's', 'p', 'r', 'e', 's', 's', 'o', '8', '9', '0'};
		System.arraycopy(charArray, 2, charArray, 6, 5);
		System.out.println(charArray[8]);
	}
}

class StandardMethods {
	StandardMethods() {
		System.out.println("Constructor invoked!");
	}

	public static void printPerimeter(double... sides) {
		double result = 0;
		for (double side : sides) {
			result += side;
		}
		System.out.println("Perimeter is " + result);
	}
}

class MainClass {
	public static void main(String[] args) {
		new StandardMethods().printPerimeter(5, 5);
	}
}