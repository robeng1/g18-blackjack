import java.util.List;

public abstract class Strategy {
    private final String name;

    public Strategy(String name) {
        this.name = name;
    }

    Move getNextMove(List<Card> deck) {
        return Move.NO_MOVE;
    }

    String getName() {
        return this.name;
    }
}
