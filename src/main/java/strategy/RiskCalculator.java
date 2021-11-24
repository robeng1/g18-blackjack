package strategy;

import black.Card;
import enums.Move;

import java.util.List;

public class RiskCalculator extends Strategy {
    @Override
    public Move calculateNextMove(List<Card> deck) {
        return super.calculateNextMove(deck);
    }

    @Override
    public  String getName() {
        return super.getName();
    }

    public RiskCalculator(String name) {
        super(name);
    }
}
