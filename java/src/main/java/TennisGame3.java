import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private final Player player1 = new Player();
    private final Player player2 = new Player();

    public TennisGame3(String player1Name, String player2Name) {
        this.player1.setName(player1Name);
        this.player2.setName(player2Name);
    }

    public String getScore() {
        String s;
        if (player1.hasScoredLessThan(4) && player2.hasScoredLessThan(4) && !scoredPointsAre(6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[player1.getNumberOfScoredPoints()];
            return player1.hasScoredTheSameNumberOfPointsAs(player2) ? s + "-All" : s + "-" + p[player2.getNumberOfScoredPoints()];
        } else {
            if (player1.hasScoredTheSameNumberOfPointsAs(player2))
                return "Deuce";
            s = player1.hasScoredMoreThan(player2) ? player1.getName() : player2.getName();
            var diff = player1MinusPlayer2Points();
            return ((diff * diff) == 1) ? ("Advantage " + s) : ("Win for " + s);
        }
    }

    private int player1MinusPlayer2Points() {
        return player1.getNumberOfScoredPoints() - player2.getNumberOfScoredPoints();
    }

    private boolean scoredPointsAre(int points) {
        return player1.getNumberOfScoredPoints() + player2.getNumberOfScoredPoints() == points;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1.getName())) {
            this.player1.scoredPoint();
        } else {
            this.player2.scoredPoint();
        }
    }

    public static class Player {

        private String name;
        private int numberOfScoredPoints;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfScoredPoints() {
            return numberOfScoredPoints;
        }

        private void scoredPoint() {
            this.numberOfScoredPoints = numberOfScoredPoints + 1;
        }

        private boolean hasScoredLessThan(int points) {
            return numberOfScoredPoints < points;
        }

        private boolean hasScoredTheSameNumberOfPointsAs(Player player2) {
            return numberOfScoredPoints == player2.numberOfScoredPoints;
        }

        private boolean hasScoredMoreThan(Player player2) {
            return numberOfScoredPoints > player2.numberOfScoredPoints;
        }
    }
}
