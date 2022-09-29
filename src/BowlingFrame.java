import java.util.Scanner;

public class BowlingFrame {
    private int id;
    private int frameStatus = 0;
    private int pinsShot;

    public BowlingFrame() {
    }

    public void shootFrame(Scanner scan) {
        int pins = scan.nextInt();
        this.pinsShot = pins;
        this.frameStatus = 1;
    }

    public void shootFrameTest(int value) {
        this.pinsShot = value;
        this.frameStatus = 1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrameStatus() {
        return this.frameStatus;
    }

    public void setFrameStatus(int frameStatus) {
        this.frameStatus = frameStatus;
    }

    public int getPinsShot() {
        return this.pinsShot;
    }

    public void setPinsShot(int pinsShot) {
        this.pinsShot = pinsShot;
    }
}