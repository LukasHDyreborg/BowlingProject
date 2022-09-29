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

            this.bowlingRounds.add(bowlingRound);
        }

    }

    public void playGame(boolean test, int... values) {
        Scanner scan = new Scanner(System.in);
        Iterator var4 = this.bowlingRounds.iterator();

        while(var4.hasNext()) {
            BowlingRound round = (BowlingRound)var4.next();
            round.roundCalc(scan, test, values);
            this.gameScore = 0;
            this.gameCalc();
            System.out.println("Game score is: " + this.gameScore);
        }

        scan.close();
    }

    public void gameCalc() {
        Iterator var1 = this.bowlingRounds.iterator();

        while(true) {
            BowlingRound round;
            label24:
            do {
                while(var1.hasNext()) {
                    round = (BowlingRound)var1.next();
                    if (round.getRoundStatus() == 1) {
                        continue label24;
                    }

                    this.gameScore += round.getRoundScore();
                }

                return;
            } while(round.getRoundType() != 2 && round.getRoundType() != 1);

            this.strikeOrSpareCalc(round.getId());
        }
    }

    public void strikeOrSpareCalc(int id) {
        int frameCount = 0;
        int score = 0;

        for(int i = id; i < this.bowlingRounds.size(); ++i) {
            Iterator var5 = ((BowlingRound)this.bowlingRounds.get(i)).getBowlingFrames().iterator();

            while(var5.hasNext()) {
                BowlingFrame frame = (BowlingFrame)var5.next();
                if (frame.getFrameStatus() == 1) {
                    score += frame.getPinsShot();
                    if (frameCount == 2) {
                        ((BowlingRound)this.bowlingRounds.get(id)).roundIsDone(score);
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