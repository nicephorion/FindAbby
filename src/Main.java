import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {

    Stage primaryStage;
    TextField nameText;
    Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        startsceen();

    }

    public Room setup() {

        // Structure Map
        Map<Integer, int[]> structure = new HashMap<>();
        structure.put(0, new int[] {1, 2, 3});
        structure.put(1, new int[] {4, 5, 6});
        structure.put(2, new int[] {6, 7, 8});
        structure.put(3, new int[] {8, -1, 9});
        structure.put(4, new int[] {10, 11, -1});
        structure.put(5, new int[] {-1, 12, 13});
        structure.put(6, new int[] {13, -1, 14});
        structure.put(7, new int[] {-1, 14, 15});
        structure.put(8, new int[] {15, -1, 16});
        structure.put(9, new int[] {16, 17, -1});
        structure.put(10, new int[] {18, -1, 19});
        structure.put(11, new int[] {-1, 19, 20});
        structure.put(12, new int[] {20, -1, 21});
        structure.put(13, new int[] {-1, 21, 22});
        structure.put(14, new int[] {22, 23, -1});
        structure.put(15, new int[] {23, -1, 24});
        structure.put(16, new int[] {24, -1, 25});
        structure.put(17, new int[] {-1, 25, -1});
        structure.put(18, new int[] {-1, -1, 26});
        structure.put(19, new int[] {-1, 26, -1});
        structure.put(20, new int[] {26, -1, -1});
        structure.put(21, new int[] {-1, -1, 27});
        structure.put(22, new int[] {27, -1, -1});
        structure.put(23, new int[] {-1, -1, 28});
        structure.put(24, new int[] {-1, 28, -1});
        structure.put(25, new int[] {28, -1, -1});
        structure.put(26, new int[] {-1, -1});
        structure.put(27, new int[] {-1, -1});
        structure.put(28, new int[] {-1, -1});

        // Variant 1
        String[] pildid = new String[]{"0.png", "2.jpg", "3.jpg"};
//        Image[] pildid = new Image[28];
//        pildid[0] = Image("0.png");
//        pildid[1] = Image("1.jpg");
//        pildid[2] = Image("2.jpg");

                Room[] rooms = new Room[pildid.length];

        for (int i = 0; i < pildid.length; i++) {
            String stringSceneBackgroundimage = pildid[i];
            Image sceneBackgroundimage = new Image (stringSceneBackgroundimage);
            Room room = new Room(sceneBackgroundimage);
            rooms[i] = room;
        }

        for (Map.Entry<Integer, int[]> paar : structure.entrySet()) {
            Integer roomNr = paar.getKey();
            int[] suunad = paar.getValue();

            int vasak = suunad[0];
            int parem = suunad[1];
            int otse = suunad[2];

            Room vaadeldavRoom = rooms[roomNr];
            // left pathway
            if (vasak == -1) {
                vaadeldavRoom.setLeft(null);
            }
            else {
                vaadeldavRoom.setLeft(rooms[vasak]);
            }
            // straight pathway
            if (otse == -1) {
                vaadeldavRoom.setStraight(null);
            }
            else {
                vaadeldavRoom.setStraight(rooms[otse]);
            }
            // right pathway
            if (parem == -1) {
                vaadeldavRoom.setRight(null);
            }
            else {
                vaadeldavRoom.setRight(rooms[parem]);
            }
        }
        return rooms[0];

        // Variant 2

//        List<Image> pildid = new ArrayList<>();
//        ArrayList<Integer> rooms = new ArrayList<>();
//        for (int i = 0; i < 28; i++) {
//            pildid.add(new Image(getClass().getResource(i + "jpg").toExternalForm()));
//            Image sceneBackgroundImage = pildid.get(i);
//            Room room = new Room(sceneBackgroundImage);
//            rooms.get(i) = room;
//        }
//
//        for (Map.Entry<Integer, int[]> paar : structure.entrySet()) {
//            Integer roomNr = paar.getKey();
//            int[] suunad = paar.getValue();
//
//            int vasak = suunad[0];
//            int parem = suunad[1];
//            int otse = suunad[2];
//
//            Room vaadeldavRoom = rooms.get(roomNr);
//            // left pathway
//            if (vasak == -1) {
//                vaadeldavRoom.setLeft(null);
//            }
//            else {
//                vaadeldavRoom.setLeft(rooms.get(vasak));
//            }
//            // straight pathway
//            if (otse == -1) {
//                vaadeldavRoom.setStraight(null);
//            }
//            else {
//                vaadeldavRoom.setStraight(rooms.get(otse));
//            }
//            // right pathway
//            if (parem == -1) {
//                vaadeldavRoom.setRight(null);
//            }
//            else {
//                vaadeldavRoom.setRight(rooms.get(parem));
//            }
//        }
//        return rooms.get(0);
    }

    public void startsceen() {
        Pane startPane = new Pane();
        Scene startScene = new Scene(startPane, 700, 600);
        mainStage = new Stage();

        //Textfields, labels and buttons
        Label startLabel = new Label("Enter your name!");
        TextField nameText = new TextField();
        Button startButton = new Button("Enter!");

        //Adding stuff to startPane
        startPane.getChildren().addAll(startLabel, nameText, startButton);
        startLabel.setTranslateX(20);
        startLabel.setTranslateY(20);
        nameText.setTranslateX(20);
        nameText.setTranslateY(60);
        startButton.setTranslateX(20);
        startButton.setTranslateY(100);

        //startButton event
        startButton.setOnAction((eventInstructions) -> {
            instructionscreen(nameText);
        });

        mainStage.setScene(startScene);
        mainStage.show();
    }

    public void instructionscreen(TextField nameText) {
        Pane instructionPane = new Pane();
        Scene instructionScene = new Scene(instructionPane, 700, 600);
        String name = nameText.getText();

        //Labels and Buttons
        Label instructions = new Label("Hello, " + name + "\nYour" +
                " sister Abby is missing. \nYou have to find her!");
        instructions.setTranslateX(20);
        instructions.setTranslateY(20);
        Button a1 = new Button("Next!");
        a1.setTranslateX(20);
        a1.setTranslateY(100);

        //How to set background images
        BackgroundImage proovbg = new BackgroundImage(new Image("IMG_0110.png", 700, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        instructionPane.setBackground(new Background(proovbg));

        // Kutsu välja setup meetod: Room first = setup();
        Room first = setup();

        // Nupule vajutades alustatakse playGame(first)
        //startButton event
        a1.setOnAction((eventStartGame) -> {
            playGame(first);
        });

        instructionPane.getChildren().addAll(instructions, a1);
        mainStage.setScene(instructionScene);

    }

    public void playGame(Room currentRoom) {

        Pane playGamePane = new Pane();
        Scene playGameScene = new Scene(playGamePane, 700, 600);

        Room vasak = currentRoom.getLeft();
        Room otse = currentRoom.getStraight();
        Room parem = currentRoom.getRight();

        // left button
        Button leftButton = new Button("Go left!");
        leftButton.setTranslateX(20);
        leftButton.setTranslateY(100);
        // event
        leftButton.setOnAction((eventInstructions) -> {
            playGame(vasak);
        });

        // straight button
        Button straightButton = new Button("Go straight!");
        straightButton.setTranslateX(20);
        straightButton.setTranslateY(100);
        // event
        straightButton.setOnAction((eventInstructions) -> {
            playGame(otse);
        });

        // right button
        Button rightButton = new Button("Go right!");
        rightButton.setTranslateX(20);
        rightButton.setTranslateY(100);
        // event
        rightButton.setOnAction((eventInstructions) -> {
            playGame(parem);
        });

        if (vasak == null && parem == null && otse == null) {
            lastScene(currentRoom);
        }

        Image bgimage = currentRoom.getBackgroundImage();

        ImageView imageView = new ImageView(bgimage);

        // adding buttons
        playGamePane.getChildren().addAll(imageView, leftButton, straightButton, rightButton);
        mainStage.setScene(playGameScene);

        if (vasak == null) {
            leftButton.setDisable(true);
        }
        if (otse == null) {
            straightButton.setDisable(true);
        }
        if (parem == null) {
            rightButton.setDisable(true);
        }

    }
    public void lastScene(Room currentRoom) {

    }

}
