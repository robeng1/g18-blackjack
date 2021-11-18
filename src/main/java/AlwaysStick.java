import java.util.List;

public class AlwaysStick extends Strategy {
    public AlwaysStick(String name) {
        super(name);
    }

    @Override
    public Move getNextMove(List<Card> deck) {
        int sumOfDeck = deck.stream().mapToInt(d -> d.getValue().getVal()).sum();
        if (sumOfDeck > 21) return Move.NO_MOVE;
        return Move.STICK;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}