import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Game {
    private final List<Player> players;
    private final List<Player> bustedPlayers = new ArrayList<>();
    private Stack<Card> deck = new Stack<>();
    private final List<Card> dealtCards = new ArrayList<>();
    private final List<Round> rounds = new ArrayList<>();
    private Player winner = null;
    private GameState gameState;


    public Game(List<Player> players) {
        this.players = players;
        this.gameState = GameState.START;
        this.generateGameDeck();
    }

    private void setGameState(Round round) {
        if (round.isAllStick()) {
            this.gameState = GameState.FINISH;
            this.makeWinner();
            return;
        }
        for (Player player : this.players) {
            if (player.getTotal() == 21) {
                this.gameState = GameState.FINISH;
                this.makeWinner();
                return;
            }
        }

        if (this.players.size() == 1) {
            this.gameState = GameState.FINISH;
            this.makeWinner();
        }

    }

    public void makeWinner() {
        if (this.gameState == GameState.FINISH) {
            List<Player> currentPlayers = this.players.stream().sorted(new PlayerSorter()).collect(Collectors.toList());
            for (Player p : currentPlayers) {
                if (p.getTotal() < 21) {
                    this.winner = p;
                    break;
                }
            }
        }

    }

    public void generateGameDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                this.deck.add(new Card(suit, value));
            }
        }
    }

    public void start() {
        Collections.shuffle(this.deck);
        this.gameState = GameState.IN_PROGRESS;
        for (Player player : this.players) {
            List<Card> hand = List.of(this.deck.pop(), this.deck.pop());
            player.deal(hand.toArray(Card[]::new));
            dealtCards.addAll(hand);

        }

    }

    public void runGameLoop() {
        while (this.gameState != GameState.FINISH) {
            List<Play> plays = new ArrayList<>();
            for (int i = 0; i < this.players.size(); i++) {
                Player player = this.players.get(i);
                if (player.getMove() == Move.HIT) {
                    Card card = this.deck.pop();
                    player.deal(card);
                    this.dealtCards.add(card);
                    plays.add(new Play(player, player.getMove()));
                } else if (player.getMove() == Move.GO_BUST) {
                    this.bustedPlayers.add(player);
                    this.players.remove(player);
                    plays.add(new Play(player, player.getMove()));
                } else if (player.getMove() == Move.STICK) {
                    plays.add(new Play(player, player.getMove()));
                }
            }
            Round round = new Round(this.rounds.size() + 1, plays);
            this.rounds.add(round);
            this.setGameState(round);
        }


    }

    public void printReport() {
//        for (Player player : this.players) {
//            Map<Suit, List<Card>> cardsByType = player.getDeck().stream()
//                    .collect(groupingBy(Card::getSuit));
//            System.out.println(player.getName() + " IS DEALT: \n");
//            for (Map.Entry<Suit, List<Card>> entry : cardsByType.entrySet()) {
////                StringBuilder str = new StringBuilder();
//
////                str.append(entry.getValue().size());
//
////                Map<Value, List<Card>> cardsByValue = entry.getValue().stream()
////                        .collect(groupingBy(Card::getValue));
//
//                System.out.println(entry.getValue().size() + " " + entry.getKey() + " " + entry.getValue());
//            }
//        }
//        for (Player player : this.bustedPlayers) {
//            Map<Suit, List<Card>> cardsByType = player.getDeck().stream()
//                    .collect(groupingBy(Card::getSuit));
//            System.out.println(player.getName() + " IS DEALT: \n");
//            for (Map.Entry<Suit, List<Card>> entry : cardsByType.entrySet()) {
////                StringBuilder str = new StringBuilder();
//
////                str.append(entry.getValue().size());
//
////                Map<Value, List<Card>> cardsByValue = entry.getValue().stream()
////                        .collect(groupingBy(Card::getValue));
//
//                System.out.println(entry.getValue().size() + " " + entry.getKey() + " " + entry.getValue());
//            }
//        }
        System.out.println("********************************* DETAILED GAME STATISTICS *********************************");
        System.out.println("Number of rounds played: " + this.rounds.size());
        for (Round round :
                this.rounds) {
            System.out.println(round);
            System.out.println("\n");
        }
        if (this.winner != null) {
            System.out.println("THE GAME WAS WON BY:  " + this.winner.getName().toUpperCase() + " WITH A TOTAL OF:" + this.winner.getTotal());
            System.out.println("\n");
        }
        if (this.bustedPlayers.size() > 0) {
            System.out.println("The following players were busted");
            for (Player player : this.bustedPlayers) {
                System.out.println(player + " with a total of " + player.getTotal());
            }
            System.out.println("\n");
        }
//        System.out.println(this.players);
//        System.out.println(this.bustedPlayers);

    }
}

// Game finished playing in 4 rounds
// Player

/*
TODO
1.



 */
