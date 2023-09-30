import java.util.Objects;

public class TennisGame3 implements TennisGame {
    
    private int player2Points;
    private int player1Points;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (player1Points < 4 && player2Points < 4 && !(player1Points + player2Points == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[player1Points];
            return (player1Points == player2Points) ? s + "-All" : s + "-" + p[player2Points];
        } else {
            if (player1Points == player2Points)
                return "Deuce";
            s = player1Points > player2Points ? player1Name : player2Name;
            return ((player1Points - player2Points)*(player1Points - player2Points) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name)) {
          this.player1Points += 1;
        } else {
          this.player2Points += 1;
        }
    }
}
