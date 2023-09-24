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
        if (player1.getNumberOfScoredPoints() < 4 && player2.getNumberOfScoredPoints() < 4 && !(player1.getNumberOfScoredPoints() + player2.getNumberOfScoredPoints() == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[player1.getNumberOfScoredPoints()];
            return (player1.getNumberOfScoredPoints() == player2.getNumberOfScoredPoints()) ? s + "-All" : s + "-" + p[player2.getNumberOfScoredPoints()];
        } else {
            if (player1.getNumberOfScoredPoints() == player2.getNumberOfScoredPoints())
                return "Deuce";
            s = player1.getNumberOfScoredPoints() > player2.getNumberOfScoredPoints() ? player1.getName() : player2.getName();
            return ((player1.getNumberOfScoredPoints() - player2.getNumberOfScoredPoints())*(player1.getNumberOfScoredPoints() - player2.getNumberOfScoredPoints()) == 1) ? "Advantage " + s : "Win for " + s;
        }
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
    }
}
