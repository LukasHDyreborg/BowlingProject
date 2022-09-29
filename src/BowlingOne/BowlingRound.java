package BowlingOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingRound {
    private int id;
    private int roundNumber; // 0 = first round. 1 = normal round. 2 = last round.
    private List<BowlingFrame> bowlingFrames = new ArrayList();
    private int roundStatus; // 0 = not Played. 1 = not Done. 2 = Done.
    private int roundType; // 0 = normal round. 1 = spare. 2 = strike.
    private int roundScore;

    public BowlingRound() {
        this.id = 0;
        // sets the round to be the first.
        this.roundNumber = 0;
        this.generateFrames();
        // sets the round status to not played.
        this.roundStatus = 0;
    }

    public BowlingRound(int id, int roundNumber) {
        this.id = id;
        this.roundNumber = roundNumber;
        this.generateFrames();
        // sets the round status to not played.
        this.roundStatus = 0;
    }

    public void generateFrames() {
        int i;
        BowlingFrame bowlingFrame;
        // if the round is the last.
        if (roundNumber == 2) {
            for(i = 0; i <= 2; ++i) {
                bowlingFrame = new BowlingFrame();
                bowlingFrames.add(bowlingFrame);
            }
        } else {
            for(i = 0; i <= 1; ++i) {
                bowlingFrame = new BowlingFrame();
                bowlingFrames.add(bowlingFrame);
            }
        }

    }

    public void roundCalc(Scanner scan, boolean test, int... values) {
        // If round is not played.
        if (roundStatus == 0) {
            // sets round to not done.
            roundStatus = 1;
            for (BowlingFrame frame : bowlingFrames) {
                if (frame.getFrameStatus() == 0) {
                    int score;
                    if (test) {
                        score = values[0];
                        frame.shootFrameTest(values[score]);
                        if (values[0] < values.length) {
                            values[0]++;
                        }
                    } else {
                        frame.shootFrame(scan);
                    }

                    if (bowlingFrames.get(0).getPinsShot() == 10) {
                        roundIsStrike();
                    }
                    else if (bowlingFrames.get(1).getFrameStatus() == 1) {
                        if (bowlingFrames.get(0).getPinsShot() + (bowlingFrames.get(1).getPinsShot()) == 10) {
                            roundIsSpare();
                        } else {
                            score = (bowlingFrames.get(0)).getPinsShot() + (bowlingFrames.get(1).getPinsShot());
                            roundIsDone(score);
                        }
                    }
                }
            }
        }
    }

    public void roundIsStrike() {
        // sets round to be a strike.
        roundType = 2;
        // if the round is not the last.
        if (roundNumber != 2) {
            bowlingFrames.get(1).setFrameStatus(2);
        }

    }

    public void roundIsSpare() {
        // sets round tto be a spare.
        roundType = 1;
    }

    public void roundIsDone(int score) {
        // sets round to done.
        roundStatus = 2;
        roundScore = score;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<BowlingFrame> getBowlingFrames() {
        return this.bowlingFrames;
    }

    public void setBowlingFrames(List<BowlingFrame> bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }

    public int getRoundStatus() {
        return this.roundStatus;
    }

    public void setRoundStatus(int roundStatus) {
        this.roundStatus = roundStatus;
    }

    public int getRoundType() {
        return this.roundType;
    }

    public void setRoundType(int roundType) {
        this.roundType = roundType;
    }

    public int getRoundScore() {
        return this.roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }
}