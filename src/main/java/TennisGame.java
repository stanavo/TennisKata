public class TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (endGameScore() == "win for " + player1Name || endGameScore() == "win for " + player2Name ) {
            return;
        }

        if (playerName.equals(player1Name)) {
            player1Points++;
        } else if (playerName.equals(player2Name)) {
            player2Points++;
        }
    }

    public String getScore() {
        if (player1Points == player2Points) {
            return equalScore();
        } else if (player1Points >= 4 || player2Points >= 4) {
            return endGameScore();
        } else {
            return normalScore();
        }
    }

    private String normalScore() {
        return pointToText(player1Points) + "-" + pointToText(player2Points);
    }

    private String equalScore() {
        switch (player1Points) {
            case 0:
                return "love-all";
            case 1:
                return "15-all";
            case 2:
                return "30-all";
            default:
                return "deuce";
        }
    }

    private String endGameScore() {
        int difference = player1Points - player2Points;

        if (difference == 1) return "advantage " + player1Name;
        if (difference == -1) return "advantage " + player2Name;
        if (difference >= 2) return "win for " + player1Name;
        return "win for " + player2Name;
    }

    private String pointToText(int points) {
        switch (points) {
            case 0:
                return "love";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                throw new IllegalArgumentException("Invalid point value");
        }
    }
}
