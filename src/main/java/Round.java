import java.util.List;

public class Round {
    private int round;
    private List<Play> plays;

    @Override
    public String toString() {
        return "Round: " + this.round + "comprised the following moves  \n" + this.plays;
    }

    public Round(int round, List<Play> plays) {
        this.round = round;
        this.plays = plays;
    }

    public void addPlay(Play... plays) {
        this.plays.addAll(List.of(plays));
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public boolean isAllStick() {
        boolean allStick = true;
        for (Play p : this.plays
        ) {
            if (p.getMove() != Move.STICK) {
                allStick = false;
                break;
            }
        }
        return allStick;
    }
}
