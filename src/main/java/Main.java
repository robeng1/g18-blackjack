import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            players.add(new Player("player-" + i, new Default("default")));
        }

        Game game = new Game(players);
        game.start();
        game.runGameLoop();
        game.printReport();
    }
}
