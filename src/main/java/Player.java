import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private final List<Card> deck = new ArrayList<>();

    @Override
    public String toString() {
        return this.getName();
    }

    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public void deal(Card... cards) {
        this.deck.addAll(List.of(cards));
    }

    public int getTotal() {
        return this.deck.stream().mapToInt(d -> d.getValue().getVal()).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    Move getMove() {
        return this.strategy.getNextMove(this.deck);
    }

}
