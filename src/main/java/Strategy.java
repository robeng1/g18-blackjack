import java.util.List;

public abstract class Strategy {
    private final String name;

    public Strategy(String name) {
        this.name = name;
    }

    Move getNextMove(List<Card> deck) {
        return Move.GO_BUST;
    }

    String getName() {
        return this.name;
    }
}
