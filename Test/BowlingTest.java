import org.junit.Test;

import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class BowlingTest {
    Scanner scan = new Scanner(System.in);
    BowlingGame bowlingGame = new BowlingGame();
    BowlingRound bowlingRound = new BowlingRound();

    @Test
    public void testMakingGame() {
        assertEquals(10, this.bowlingGame.getBowlingRounds().size());
    }

    @Test
    public void testRound() {
        int[] values = new int[]{1, 4, 5};
        this.bowlingRound.roundCalc(this.scan, true, values);
        assertEquals(9, this.bowlingRound.getRoundScore());
    }
}