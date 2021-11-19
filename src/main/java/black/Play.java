package black;

import enums.Move;

public class Play {
    private Player player;
    private Move move;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return this.player.getName() + " played: " + this.move.toString();
    }

    public Play(Player player, Move move) {
        this.player = player;
        this.move = move;
    }
}
