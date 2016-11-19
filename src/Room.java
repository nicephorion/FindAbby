import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Room {

    Image backgroundImage;
    //Image pic = new Image("IMG_0110.png");
    Scene left;
    Scene straight;
    Scene right;

    //String vasak, otse, parem;

    public Room (Image sceneBackgroundImage, Scene nextLeft, Scene nextStraight, Scene nextRight) {
        backgroundImage = sceneBackgroundImage;
        left = nextLeft;
        straight = nextStraight;
        right = nextRight;
    }

    public void setBackgroundImage (Image sceneBackgroundImage) {
        backgroundImage = sceneBackgroundImage;
    }
    public void setNextLeft (Scene nextLeft) {
        left = nextLeft;
    }
    public void setNextStraight (Scene nextStraight) {
        left = nextStraight;
    }
    public void setNextRight (Scene nextRight) {
        left = nextRight;
    }


}
