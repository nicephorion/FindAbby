import javafx.scene.image.Image;

public class Room {

    Image backgroundImage;
    Room left;
    Room straight;
    Room right;
    boolean win;
    boolean lose;

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

    public void setStraight(Room straight) {
        this.straight = straight;
    }

    // right pathway
    public Room getRight() {
        return right;
    }

    public void setRight(Room right) {
        this.right = right;
    }

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
