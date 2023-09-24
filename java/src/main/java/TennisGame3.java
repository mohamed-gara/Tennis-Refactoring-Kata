import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private final Player player1 = new Player();

    private String player2Name;
    private int player2Points;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1.setName(player1Name);
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (player1.getNumberOfScoredPoints() < 4 && player2Points < 4 && !(player1.getNumberOfScoredPoints() + player2Points == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[player1.getNumberOfScoredPoints()];
            return (player1.getNumberOfScoredPoints() == player2Points) ? s + "-All" : s + "-" + p[player2Points];
        } else {
            if (player1.getNumberOfScoredPoints() == player2Points)
                return "Deuce";
            s = player1.getNumberOfScoredPoints() > player2Points ? player1.getName() : player2Name;
            return ((player1.getNumberOfScoredPoints() - player2Points)*(player1.getNumberOfScoredPoints() - player2Points) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1.getName())) {
            this.player1.setNumberOfScoredPoints(this.player1.getNumberOfScoredPoints() + 1);
        } else {
          this.player2Points += 1;
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

        public void setNumberOfScoredPoints(int numberOfScoredPoints) {
            this.numberOfScoredPoints = numberOfScoredPoints;
        }
    }
}
