
public class TennisGame1 implements TennisGame {
    
    private int player1ScoredPoints = 0;
    private int player2ScoredPoints = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            player1ScoredPoints += 1;
        else
            player2ScoredPoints += 1;
    }

    public String getScore() {
        if (playersHasScoredTheSamePoints()) {
            return equalsScore();
        } else if (scoreIsOrWasDeuce()) {
            return tryToWinTwoConsecutivePointsScore();
        } else {
            return beforeDeuceScore();
        }
    }

    private boolean playersHasScoredTheSamePoints() {
        return player1ScoredPoints == player2ScoredPoints;
    }

    private String equalsScore() {
        String score;
        switch (player1ScoredPoints)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private String tryToWinTwoConsecutivePointsScore() {
        String score;
        int minusResult = player1ScoredPoints - player2ScoredPoints;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean scoreIsOrWasDeuce() {
        return player1ScoredPoints >= 4 || player2ScoredPoints >= 4;
    }

    private String beforeDeuceScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = player1ScoredPoints;
            else { score +="-"; tempScore = player2ScoredPoints;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }
}
