package BowlingOne;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
    private int id;
    private List<BowlingRound> bowlingRounds = new ArrayList();
    private int gameScore;

    public BowlingGame() {
        this.generateRounds();
        this.gameScore = 0;
    }

    public void generateRounds() {
        for(int i = 0; i < 10; ++i) {
            BowlingRound bowlingRound;
            if (i == 0) {
                bowlingRound = new BowlingRound(i, 0);
            } else if (i == 9) {
                bowlingRound = new BowlingRound(i, 2);
            } else {
                bowlingRound = new BowlingRound(i, 1);
            }

            bowlingRounds.add(bowlingRound);
        }

    }

    public void playGame(boolean test, int... values) {
        Scanner scan = new Scanner(System.in);
        for (BowlingRound round : bowlingRounds) {
            round.roundCalc(scan, test, values);
            gameScore = 0;
            gameCalc();
            System.out.println("Game score is: " + gameScore);
        }
        scan.close();
    }

    public void gameCalc() {
        int score = 0;
        for (BowlingRound round : bowlingRounds) {
            // if round is not done.
            if (round.getRoundStatus() == 1) {
                strikeOrSpareCalc(round.getId());
            }
            score += round.getRoundScore();
        }
        gameScore = score;
    }

    public void strikeOrSpareCalc(int id) {
        int frameCount = 0;
        int score = 0;

        for(int i = id; i < bowlingRounds.size(); ++i) {
            for (BowlingFrame frame : bowlingRounds.get(i).getBowlingFrames()) {
                if (frame.getFrameStatus() == 1) {
                    score += frame.getPinsShot();
                    if (frameCount == 2) {
                        bowlingRounds.get(id).roundIsDone(score);
                    }
                    ++frameCount;
                }
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BowlingRound> getBowlingRounds() {
        return this.bowlingRounds;
    }

    public void setBowlingRounds(List<BowlingRound> bowlingRounds) {
        this.bowlingRounds = bowlingRounds;
    }

    public int getGameScore() {
        return this.gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
}