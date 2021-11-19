package strategy;

import black.Card;
import enums.Move;

import java.util.List;

public class AlwaysStick extends Strategy {
    public AlwaysStick(String name) {
        super(name);
    }

    @Override
    public Move calculateNextMove(List<Card> deck) {
        int sumOfDeck = deck.stream().mapToInt(d -> d.getValue().getVal()).sum();
        if (sumOfDeck > 21) return Move.GO_BUST;
        return Move.STICK;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}