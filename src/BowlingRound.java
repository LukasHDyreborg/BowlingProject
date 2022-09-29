import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BowlingRound {
    private int id;
    private int roundNumber;
    private List<BowlingFrame> bowlingFrames = new ArrayList();
    private int roundStatus;
    private int roundType;
    private int roundScore;

    public BowlingRound() {
        this.id = 0;
        this.roundNumber = 0;
        this.generateFrames();
        this.roundStatus = 0;
    }

    public BowlingRound(int id, int roundNumber) {
        this.id = id;
        this.roundNumber = roundNumber;
        this.generateFrames();
        this.roundStatus = 0;
    }

    public void generateFrames() {
        int i;
        BowlingFrame bowlingFrame;
        if (this.roundNumber == 2) {
            for(i = 0; i <= 2; ++i) {
                bowlingFrame = new BowlingFrame();
                this.bowlingFrames.add(bowlingFrame);
            }
        } else {
            for(i = 0; i <= 1; ++i) {
                bowlingFrame = new BowlingFrame();
                this.bowlingFrames.add(bowlingFrame);
            }
        }

    }

    public void roundCalc(Scanner scan, boolean test, int... values) {
        if (this.roundStatus == 0) {
            this.roundStatus = 1;
            Iterator var4 = this.bowlingFrames.iterator();

            while(var4.hasNext()) {
                BowlingFrame frame = (BowlingFrame)var4.next();
                if (frame.getFrameStatus() == 0) {
                    int score;
                    if (test) {
                        score = values[0];
                        frame.shootFrameTest(values[score]);
                        if (values[0] < values.length) {
                            int var10002 = values[0]++;
                        }
                    } else {
                        frame.shootFrame(scan);
                    }

                    if (((BowlingFrame)this.getBowlingFrames().get(0)).getPinsShot() == 10) {
                        this.roundIsStrike();
                    } else if (((BowlingFrame)this.getBowlingFrames().get(1)).getFrameStatus() == 1) {
                        if (((BowlingFrame)this.getBowlingFrames().get(0)).getPinsShot() + ((BowlingFrame)this.getBowlingFrames().get(1)).getPinsShot() == 10) {
                            this.roundIsSpare();
                        } else {
                            score = ((BowlingFrame)this.getBowlingFrames().get(0)).getPinsShot() + ((BowlingFrame)this.getBowlingFrames().get(1)).getPinsShot();
                            this.roundIsDone(score);
                        }
                    }
                }
            }
        }

    }

    public void roundIsStrike() {
        this.roundType = 2;
        if (this.roundNumber != 2) {
            ((BowlingFrame)this.bowlingFrames.get(1)).setFrameStatus(2);
        }

    }

    public void roundIsSpare() {
        this.roundType = 1;
    }

    public void roundIsDone(int score) {
        this.roundStatus = 2;
        this.roundScore = score;
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