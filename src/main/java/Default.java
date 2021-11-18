import java.util.List;

public class Default extends Strategy {
    public Default(String name) {
        super(name);
    }

    @Override
    public Move getNextMove(List<Card> deck) {
        int sumOfDeck = deck.stream().mapToInt(d -> d.getValue().getVal()).sum();
        if (sumOfDeck < 17) return Move.HIT;
        if (sumOfDeck < 21) return Move.STICK;
        return Move.GO_BUST;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
