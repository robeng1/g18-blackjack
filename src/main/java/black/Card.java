package black;

import enums.Suit;
import enums.Value;

public class Card {
    private Suit suit;
    private Value value;

    @Override
    public String toString() {
        return "black.Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
