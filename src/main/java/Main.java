import black.Game;
import black.Player;
import shuffler.Pharoah;
import shuffler.Riffle;
import strategy.AlwaysHit;
import strategy.AlwaysStick;
import strategy.Default;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main {
    public static boolean hasValidParameters(String[] args) {
        return args.length == 1 || (args.length > 2 && args.length < 13 && args.length % 2 == 0);
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        int numberOfPlayers;
        if (args.length <= 0) {
            numberOfPlayers = 3;
            for (int i = 0; i < numberOfPlayers; i++) {
                players.add(new Player("player-" + i, new Default("default")));
            }
        } else {
            if (!hasValidParameters(args)) {
                System.out.println("Please provide a valid number of parameters");
                exit(0);
            }
        }

        if (args.length == 1) {
            numberOfPlayers = parseInt(args[0]);
            for (int i = 0; i < numberOfPlayers; i++) {
                players.add(new Player("player-" + i, new Default("default")));
            }
        } else {
            for (int i = 1; i < args.length; i += 2) {
                if (Objects.equals(args[i], "always-hit")) {
                    players.add(new Player("player-" + (i - 1), new AlwaysHit("always-hit")));
                } else if (Objects.equals(args[i], "always-stick")) {
                    players.add(new Player("player-" + (i - 1), new AlwaysStick("always-stick")));
                } else {
                    players.add(new Player("player-" + (i - 1), new Default("default")));
                }

            }
        }

        Game game = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your shuffling mechanism");
        String shuffleName = scanner.nextLine();

        if (Objects.equals(shuffleName, "riffle")) {
            Riffle riffle = new Riffle();
            game = new Game(players, riffle);

        } else if (Objects.equals(shuffleName, "pharoah")) {
            Pharoah pharoah = new Pharoah();
            game = new Game(players, pharoah);
        }
        assert game != null;
        game.start();
        game.runGameLoop();
        game.printReport();
    }

}
