import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name,
                      int matchesPlayed,
                      double battingAverage,
                      boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only rule
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Matches + fitness rule
        static boolean isDraftable(int matchesPlayed,
                                   boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        // Compare players by batting average
        // in descending order
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }
    }

    static String draftAndRank(Player[] players) {

        // Count draftable players
        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed) ||
                Player.isDraftable(player.matchesPlayed,
                                   player.injured)) {

                count++;
            }
        }

        // Create array containing only draftable players
        Player[] draftable = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed) ||
                Player.isDraftable(player.matchesPlayed,
                                   player.injured)) {

                draftable[index] = player;
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        // Create final output
        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result +
                     (i + 1) +
                     ". " +
                     draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}   
