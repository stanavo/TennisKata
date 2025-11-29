import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisGameTest {

    private TennisGame game;

    @Before
    public void setup() {
        game = new TennisGame("Player1", "Player2");
    }

    private void scoreMany(String player, int times) {
        for (int i = 0; i < times; i++) {
            game.wonPoint(player);
        }
    }

    @Test
    public void test_initial_score_is_love_all() {
        assertEquals("love-all", game.getScore());
    }

    @Test
    public void test_player1_scores_once() {
        scoreMany("Player1", 1);
        assertEquals("15-love", game.getScore());
    }

    @Test
    public void test_player2_scores_twice() {
        scoreMany("Player2", 2);
        assertEquals("love-30", game.getScore());
    }

    @Test
    public void test_both_score_three_times_deuce() {
        scoreMany("Player1", 3);
        scoreMany("Player2", 3);
        assertEquals("deuce", game.getScore());
    }

    @Test
    public void test_player1_gets_advantage() {
        scoreMany("Player1", 4);
        scoreMany("Player2", 3);
        assertEquals("advantage Player1", game.getScore());
    }

    @Test
    public void test_player2_gets_advantage() {
        scoreMany("Player1", 3);
        scoreMany("Player2", 4);
        assertEquals("advantage Player2", game.getScore());
    }

    @Test
    public void test_player1_wins_after_advantage() {
        scoreMany("Player1", 5);
        scoreMany("Player2", 3);
        assertEquals("win for Player1", game.getScore());
    }

    @Test
    public void test_player2_wins_straight() {
        scoreMany("Player2", 4);
        assertEquals("win for Player2", game.getScore());
    }
}

