import java.util.List;

public class AlwaysHit extends Strategy {
    public AlwaysHit(String name) {
        super(name);
    }

    @Override
    public Move getNextMove(List<Card> deck) {
        int sumOfDeck = deck.stream().mapToInt(d -> d.getValue().getVal()).sum();
        if (sumOfDeck > 21) return Move.GO_BUST;
        return Move.HIT;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}