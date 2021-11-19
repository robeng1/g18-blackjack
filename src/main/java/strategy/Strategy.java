package strategy;

import black.Card;
import enums.Move;

import java.util.List;

public abstract class Strategy {
    private final String name;

    public Strategy(String name) {
        this.name = name;
    }

    public Move calculateNextMove(List<Card> deck) {
        return Move.GO_BUST;
    }

    public String getName() {
        return this.name;
    }
}
