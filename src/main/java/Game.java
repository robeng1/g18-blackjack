import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Player> bustedPlayers = new ArrayList<>();
    private List<Card> deck;
    private Integer numberOfRounds = 0;
    private Player winner = null;
    private GameState gameState;


    public Game(List<Player> players) {
        this.players = players;
        this.generateGameDeck();
        Collections.shuffle(deck);
    }


    public void generateGameDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                this.deck.add(new Card(suit, value));
            }
        }
    }

    public void shuffleCards() {

    }



}
