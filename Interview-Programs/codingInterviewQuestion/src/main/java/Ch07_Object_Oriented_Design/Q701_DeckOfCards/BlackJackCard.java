package Ch07_Object_Oriented_Design.Q701_DeckOfCards;

import Ch07_Object_Oriented_Design.Q701_DeckOfCards.model.Card;
import Ch07_Object_Oriented_Design.Q701_DeckOfCards.model.Suit;

public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    @Override
    public int value() {
        if (isAce()) { // Ace
            return 1;
        } else if (faceValue >= 11 && faceValue <= 13) { // Face card
            return 10;
        } else { // Number card
            return faceValue;
        }
    }

    public int minValue() {
        if (isAce()) { // Ace
            return 1;
        } else {
            return value();
        }
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return 11;
        } else {
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
}
