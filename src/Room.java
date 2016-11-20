import javafx.scene.image.Image;

public class Room {

    Image backgroundImage;
    Room left;
    Room straight;
    Room right;
    boolean victory;

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

    // victory
    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }
}
