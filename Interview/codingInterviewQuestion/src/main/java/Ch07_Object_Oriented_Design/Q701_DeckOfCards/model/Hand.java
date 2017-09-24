package Ch07_Object_Oriented_Design.Q701_DeckOfCards.model;

import java.util.ArrayList;

public class Hand<T extends Card> {
	protected final ArrayList<T> cards = new ArrayList<>();

	public int score() {
		int score = 0;
		for (T card : cards) {
			score += card.value();
		}
		return score;
	}

	public void addCard(T card) {
		cards.add(card);
	}

	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}