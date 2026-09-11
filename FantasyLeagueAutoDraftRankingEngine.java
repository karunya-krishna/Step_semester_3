import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {
    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        public static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        private double fantasyPoints() {
            return matchesPlayed * 5.0 + battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }

        private boolean isDraftablePlayer() {
            return isDraftable(matchesPlayed) || isDraftable(matchesPlayed, injured);
        }

        private String display() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = Arrays.stream(players)
                .filter(Player::isDraftablePlayer)
                .toArray(Player[]::new);

        Arrays.sort(draftable);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable[i].display());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
