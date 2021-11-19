import black.Game;
import black.Player;
import strategy.AlwaysHit;
import strategy.AlwaysStick;
import strategy.Default;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main {
    public static boolean hasValidParameters(String[] args) {
        return args.length == 1 || (args.length > 2 && args.length < 13 && args.length % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        int numberOfPlayers;
        if (args.length <= 0) {
            numberOfPlayers = 3;
        } else {
            if (!hasValidParameters(args)) {
                System.out.println("Please provide a valid number of parameters");
                exit(0);
            }
        }
        List<Player> players = new ArrayList<>();
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

        Game game = new Game(players);
        game.start();
        game.runGameLoop();
        game.printReport();
    }
}


// Refactor into packages