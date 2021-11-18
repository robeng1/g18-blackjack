import java.util.Comparator;

class PlayerSorter implements Comparator<Player> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Player a, Player b) {
        return b.getTotal() - a.getTotal();
    }
}
  