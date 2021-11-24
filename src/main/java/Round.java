import java.util.List;

public class Round {
    private int round;
    private List<Play> plays;

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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Round: ").append(this.round).append(" comprised the following moves  \n");
        for (Play play :
                this.plays) {
            str.append(play.toString()).append("\n");
        }
        return str.toString();
    }
}
