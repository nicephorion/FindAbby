import javafx.scene.image.Image;

public class Room {

    private Image backgroundImage;
    private String storyText;
    private Room left;
    private Room straight;
    private Room right;
    private boolean win;
    private boolean lose;

    //constructor
    public Room (Image sceneBackgroundImage) {
        backgroundImage = sceneBackgroundImage;
    }

    // backgroundimage
    public Image getBackgroundImage() {
        return backgroundImage;
    }

    // left pathway
    public Room getLeft() {
        return left;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    // straight pathway
    public Room getStraight() {
        return straight;
    }

    public void setStraight(Room straight) { this.straight = straight; }

    // right pathway
    public Room getRight() {
        return right;
    }

    public void setRight(Room right) {
        this.right = right;
    }

    // text
    public String getStoryText() { return storyText; }

    public void setStoryText(String storyText) { this.storyText = storyText; }

    // win or lose
    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }
}
