package black;

import black.Card;
import enums.Move;
import strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private final List<Card> hand = new ArrayList<>();

    @Override
    public String toString() {
        return this.getName();
    }

    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public boolean isBusted() {
        return this.getTotal() > 21;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void deal(Card... cards) {
        this.hand.addAll(List.of(cards));
    }

    public int getTotal() {
        return this.hand.stream().mapToInt(d -> d.getValue().getVal()).sum();
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

    public Move getMove() {
        return this.strategy.calculateNextMove(this.hand);
    }

}
