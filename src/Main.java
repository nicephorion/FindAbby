import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    
    private TextField nameText;
    private Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        startscreen();
    }

    public Room setup() {

        // Structure Map
        Map<Integer, int[]> structure = new HashMap<>();
        structure.put(0, new int[] {1, 2, 3});
        structure.put(1, new int[] {4, 5, 6});
        structure.put(2, new int[] {6, 7, 8});
        structure.put(3, new int[] {8, 30, 9});
        structure.put(4, new int[] {10, 11, 30});
        structure.put(5, new int[] {30, 12, 13});
        structure.put(6, new int[] {13, 30, 14});
        structure.put(7, new int[] {30, 14, 15});
        structure.put(8, new int[] {15, 30, 16});
        structure.put(9, new int[] {16, 17, 30});
        structure.put(10, new int[] {18, 30, 19});
        structure.put(11, new int[] {30, 19, 20});
        structure.put(12, new int[] {20, 30, 21});
        structure.put(13, new int[] {30, 21, 22});
        structure.put(14, new int[] {22, 23, 30});
        structure.put(15, new int[] {23, 30, 24});
        structure.put(16, new int[] {24, 30, 25});
        structure.put(17, new int[] {30, 25, 30});
        structure.put(18, new int[] {30, 30, 26});
        structure.put(19, new int[] {30, 26, 30});
        structure.put(20, new int[] {26, 30, 30});
        structure.put(21, new int[] {30, 30, 27});
        structure.put(22, new int[] {27, 30, 30});
        structure.put(23, new int[] {30, 30, 28});
        structure.put(24, new int[] {30, 28, 30});
        structure.put(25, new int[] {28, 30, 30});
        structure.put(26, new int[] {30, 30, 29});
        structure.put(27, new int[] {30, 29, 30});
        structure.put(28, new int[] {30, 29, 30});
        // 29- win, 30 - lose
        structure.put(29, new int[] {-1, -1, -1});
        structure.put(30, new int[] {-1, -1, -1});

        // text map
        Map<Integer, String> textmap = new HashMap<>();
        textmap.put(0, "ahjeebus");
        textmap.put(1, "ohjeebus");
        textmap.put(2, "nonii");
        textmap.put(3, "nondaviisi");
        textmap.put(4, "karabkah");
        textmap.put(5, "niijanaajanoo");
        textmap.put(6, "naajaniijanoo");
        textmap.put(7, "noojanaajanii");
        textmap.put(8, "");
        textmap.put(9, "");
        textmap.put(10, "");
        textmap.put(11, "");
        textmap.put(12, "");
        textmap.put(13, "");
        textmap.put(14, "");
        textmap.put(15, "");
        textmap.put(16, "");
        textmap.put(17, "");
        textmap.put(18, "");
        textmap.put(19, "");
        textmap.put(20, "");
        textmap.put(21, "");
        textmap.put(22, "");
        textmap.put(23, "");
        textmap.put(24, "");
        textmap.put(25, "");
        textmap.put(26, "");
        textmap.put(27, "");
        textmap.put(28, "");
        textmap.put(29, "");
        textmap.put(30, "");

        // pictures
        String[] pildid = new String[]{"0.JPG", "1.JPG", "2.JPG", "3.JPG", "4.JPG", "5.JPG",  "6.JPG",
                "7.JPG", "8.JPG", "9.JPG", "10.JPG", "11.JPG", "12.JPG", "13.JPG", "14.JPG",
                "15.JPG", "16.JPG", "17.JPG", "18.JPG", "19.JPG", "20.JPG", "21.JPG", "22.JPG", "23.JPG",
                "24.JPG", "25.JPG", "26.JPG", "27.JPG", "28.JPG", "29.JPG", "30.JPG"};

        Room[] rooms = new Room[pildid.length];

        for (int i = 0; i < pildid.length; i++) {
            String stringSceneBackgroundimage = pildid[i];
            Image sceneBackgroundimage = new Image (stringSceneBackgroundimage);
            Room room = new Room(sceneBackgroundimage);
            rooms[i] = room;
        }

        //For tsükli loomisel küsisin targemalt abi.
        for (Map.Entry<Integer, int[]> paar : structure.entrySet()) {
            Integer roomNr = paar.getKey();
            int[] suunad = paar.getValue();

            int vasak = suunad[0];
            int otse = suunad[1];
            int parem = suunad[2];

            Room vaadeldavRoom = rooms[roomNr];

            String text = textmap.get(roomNr);
            vaadeldavRoom.setStoryText(text);

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

        rooms[29].setWin(true);
        rooms[30].setLose(true);
        return rooms[0];

    }

    public void startscreen() {
        Pane startPane = new Pane();
        Scene startScene = new Scene(startPane, 700, 600);
        mainStage = new Stage();

        //Textfields, labels and buttons
        Label startLabel = new Label("Enter your name!");
        nameText = new TextField();
        Button startButton = new Button("Enter!");

        Image bgimage = new Image("40.JPG");
        ImageView imageView = new ImageView(bgimage);

        //Adding stuff to startPane
        startPane.getChildren().addAll(imageView, startLabel, nameText, startButton);
        startLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
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
        instructions.setScaleX(2);
        instructions.setScaleX(2);
        instructions.setTranslateX(80);
        instructions.setTranslateY(20);

        Button a1 = new Button("Next!");
        a1.setTranslateX(20);
        a1.setTranslateY(100);

        Image bgimage = new Image("40.JPG");
        ImageView imageView = new ImageView(bgimage);

        // Kutsu välja setup meetod: Room first = setup();
        Room first = setup();

        // Nupule vajutades alustatakse playGame(first)
        //startButton event
        a1.setOnAction((eventStartGame) -> {
            playGame(first);
        });

        instructionPane.getChildren().addAll(imageView, instructions, a1);
        mainStage.setScene(instructionScene);

    }

    public void playGame(Room currentRoom) {

        if (currentRoom.isWin() || currentRoom.isLose()) {
            lastScene(currentRoom);
            return;
        }

        Pane playGamePane = new Pane();
        Scene playGameScene = new Scene(playGamePane, 700, 600);

        Room vasak = currentRoom.getLeft();
        Room otse = currentRoom.getStraight();
        Room parem = currentRoom.getRight();

        // left button
        Button leftButton = new Button("Go left!");
        leftButton.setTranslateX(20);
        leftButton.setTranslateY(500);
        // event
        leftButton.setOnAction((eventInstructions) -> {
            //if vasak == -1 { lastScene }
            playGame(vasak);
        });

        // straight button
        Button straightButton = new Button("Go straight!");
        straightButton.setTranslateX(300);
        straightButton.setTranslateY(500);
        // event
        straightButton.setOnAction((eventInstructions) -> {
            playGame(otse);
        });

        // right button
        Button rightButton = new Button("Go right!");
        rightButton.setTranslateX(600);
        rightButton.setTranslateY(500);
        // event
        rightButton.setOnAction((eventInstructions) -> {
            playGame(parem);
        });

        if (vasak == null && parem == null && otse == null) {
            lastScene(currentRoom);
        }

        // story text
        Label storyTextLabel = new Label(currentRoom.getStoryText());
        storyTextLabel.setTranslateX(100);
        storyTextLabel.setTranslateY(100);

        // background image
        Image bgimage = currentRoom.getBackgroundImage();

        ImageView imageView = new ImageView(bgimage);

        // adding buttons and background to the pane
        playGamePane.getChildren().addAll(imageView, storyTextLabel, leftButton, straightButton, rightButton);
        mainStage.setScene(playGameScene);

        if (vasak == null) {
            leftButton.setVisible(false);
        }
        if (otse == null) {
            straightButton.setVisible(false);
        }
        if (parem == null) {
            rightButton.setVisible(false);
        }

    }
    public void lastScene(Room currentRoom) {

        Pane lastScenePane = new Pane();
        Scene lastSceneScene = new Scene(lastScenePane, 700, 600);

        Image bgimage = currentRoom.getBackgroundImage();
        ImageView imageView = new ImageView(bgimage);

        Button playAgainButton = new Button ("Play again!");
        playAgainButton.setTranslateX(20);
        playAgainButton.setTranslateY(500);
        playAgainButton.setOnAction((eventPlayAgain) -> {
            System.out.println("Play again");
            instructionscreen(nameText);
        });

        Button exitButton = new Button ("Exit game!");
        exitButton.setTranslateX(600);
        exitButton.setTranslateY(500);
        exitButton.setOnAction((eventexit) -> {
            System.out.println("Exit game!");
            Platform.exit();
        });

        if (currentRoom.isWin()) {
            Label winLabel = new Label ("You found your sister! Good job!");
            winLabel.setScaleX(3);
            winLabel.setScaleY(3);
            winLabel.setTranslateX(150);
            winLabel.setTranslateY(100);

            lastScenePane.getChildren().addAll (imageView, playAgainButton, exitButton, winLabel);
        } else {
            Label loseLabel = new Label ("Oh, no! You deadd!!");
            loseLabel.setScaleX(3);
            loseLabel.setScaleY(3);
            loseLabel.setTranslateX(150);
            loseLabel.setTranslateY(100);

            lastScenePane.getChildren().addAll (imageView, playAgainButton, exitButton, loseLabel);
        }
        mainStage.setScene(lastSceneScene);
    }

}
