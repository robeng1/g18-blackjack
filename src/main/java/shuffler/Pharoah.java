package shuffler;

import black.Card;

import java.util.Collections;
import java.util.List;

public class Pharoah implements Shuffler {
    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
        System.out.println("inside pharoah");

    }
}
