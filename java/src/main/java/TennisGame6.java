public class TennisGame6 implements TennisGame {
  private final String player1Name;
  private final String player2Name;
  private int player1Score;
  private int player2Score;

  public TennisGame6(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  @Override
  public void wonPoint(String playerName) {
    if (playerName.equals("player1"))
      player1Score++;
    else
      player2Score++;
  }

  public String getScore() {
    if (isTie()) {
      return tieScore();
    } else if (isEndGame()) {
      return endGameScore();
    } else {
      return regularScore();
    }
  }

  private boolean isTie() {
    return player1Score == player2Score;
  }

  private String tieScore() {
    return switch (player1Score) {
      case 0 -> "Love-All";
      case 1 -> "Fifteen-All";
      case 2 -> "Thirty-All";
      default -> "Deuce";
    };
  }

  private boolean isEndGame() {
    return player1Score >= 4 || player2Score >= 4;
  }

  private String endGameScore() {
    if (player1Score - player2Score == 1) {
      return "Advantage " + player1Name;
    } else if (player1Score - player2Score == -1) {
      return "Advantage " + player2Name;
    } else if (player1Score - player2Score >= 2) {
      return "Win for " + player1Name;
    } else {
      return "Win for " + player2Name;
    }
  }

  private String regularScore() {
    return scoreOf(player1Score) + "-" + scoreOf(player2Score);
  }

  private String scoreOf(int player1Score) {
    return switch (player1Score) {
      case 0 -> "Love";
      case 1 -> "Fifteen";
      case 2 -> "Thirty";
      default -> "Forty";
    };
  }
}
