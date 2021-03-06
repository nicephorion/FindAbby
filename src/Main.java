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

        // structure Map
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
        // 29 - win, 30 - lose
        structure.put(29, new int[] {-1, -1, -1});
        structure.put(30, new int[] {-1, -1, -1});

        // text map
        Map<Integer, String> textmap = new HashMap<>();
        textmap.put(0, "Where could have she gone?");
        textmap.put(1, "It's cold outside, hurry!");
        textmap.put(2, "She must be so scared...");
        textmap.put(3, "Where did you saw her last?");
        textmap.put(4, "Was she wearing a red scarf...?");
        textmap.put(5, "Keep on looking!");
        textmap.put(6, "Is it her hat on that branch?");
        textmap.put(7, "You looked away for just a second.");
        textmap.put(8, "Did you see that?!?");
        textmap.put(9, "Your parents will be so angry...");
        textmap.put(10, "Go on, go on!");
        textmap.put(11, "It's freezing!");
        textmap.put(12, "Don't give up!");
        textmap.put(13, "Why didn't you keep holding her hand?");
        textmap.put(14, "There's a strange smell...");
        textmap.put(15, "Iit might rain tonight.");
        textmap.put(16, "She is still so young!");
        textmap.put(17, "She must be hungry!");
        textmap.put(18, "Come-on! You can do it!");
        textmap.put(19, "Keep on moving!");
        textmap.put(20, "Brrr, it's so cold!");
        textmap.put(21, "Are you freezing already?");
        textmap.put(22, "She cannot be far anymore!");
        textmap.put(23, "What was the last thing you said to her?");
        textmap.put(24, "The wind is rising!");
        textmap.put(25, "She must be so scared...");
        textmap.put(26, "Why didn't you keep your eye on her?!?");
        textmap.put(27, "There are dark clouds gathering!");
        textmap.put(28, "The sun is already setting!");
        textmap.put(29, "You found your sister! Good job!");
        textmap.put(30, "Oh, no! You deadd!!");

        // pictures
        String[] pictures = new String[]{"0.JPG", "1.JPG", "2.JPG", "3.JPG", "4.JPG", "5.JPG",
                "6.JPG", "7.JPG", "8.JPG", "9.JPG", "10.JPG", "11.JPG", "12.JPG", "13.JPG",
                "14.JPG", "15.JPG", "16.JPG", "17.JPG", "18.JPG", "19.JPG", "20.JPG",
                "21.JPG", "22.JPG", "23.JPG", "24.JPG", "25.JPG", "26.JPG", "27.JPG",
                "28.JPG", "29.JPG", "30.JPG"};

        Room[] rooms = new Room[pictures.length];

        // cycle to add images to rooms
        for (int i = 0; i < pictures.length; i++) {
            String stringSceneBackgroundimage = pictures[i];
            Image sceneBackgroundimage = new Image (stringSceneBackgroundimage);
            Room room = new Room(sceneBackgroundimage);
            rooms[i] = room;
        }

        // asked help for the next cycle
        // cycle to add pathways and text to rooms
        for (Map.Entry<Integer, int[]> entry : structure.entrySet()) {

            Integer roomNr = entry.getKey();

            int[] pathways = entry.getValue();
            int left = pathways[0];
            int straight = pathways[1];
            int right = pathways[2];

            Room thisRoom = rooms[roomNr];

            String text = textmap.get(roomNr);
            thisRoom.setStoryText(text);

            // left pathway
            if (left == -1) {
                thisRoom.setLeft(null);
            }
            else {
                thisRoom.setLeft(rooms[left]);
            }
            // straight pathway
            if (straight == -1) {
                thisRoom.setStraight(null);
            }
            else {
                thisRoom.setStraight(rooms[straight]);
            }
            // right pathway
            if (right == -1) {
                thisRoom.setRight(null);
            }
            else {
                thisRoom.setRight(rooms[right]);
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

        // textfields, labels and buttons
        Label startLabel = new Label("Enter your name!");
        nameText = new TextField();
        Button startButton = new Button("Enter!");

        Image bgimage = new Image("40.JPG");
        ImageView imageView = new ImageView(bgimage);

        // adding stuff to startPane
        startPane.getChildren().addAll(imageView, startLabel, nameText, startButton);
        startLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        startLabel.setTranslateX(20);
        startLabel.setTranslateY(40);

        nameText.setTranslateX(20);
        nameText.setTranslateY(80);
        startButton.setTranslateX(20);
        startButton.setTranslateY(120);

        // startButton event
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

        // labels and Buttons
        Label instructions = new Label("Hello, " + name + "\nYour" +
                " sister Abby is missing. \nYou have to find her!");
        instructions.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        instructions.setTranslateX(20);
        instructions.setTranslateY(40);

        Button a1 = new Button("Next!");
        a1.setTranslateX(20);
        a1.setTranslateY(120);

        Image bgimage = new Image("40.JPG");
        ImageView imageView = new ImageView(bgimage);

        // call out the setup method
        Room first = setup();

        // (a1) button event to start the game
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

        Room left = currentRoom.getLeft();
        Room straight = currentRoom.getStraight();
        Room right = currentRoom.getRight();

        // left button
        Button leftButton = new Button("Go left!");
        leftButton.setTranslateX(20);
        leftButton.setTranslateY(500);
        // event
        leftButton.setOnAction((eventInstructions) -> {
            playGame(left);
        });

        // straight button
        Button straightButton = new Button("Go straight!");
        straightButton.setTranslateX(300);
        straightButton.setTranslateY(500);
        // event
        straightButton.setOnAction((eventInstructions) -> {
            playGame(straight);
        });

        // right button
        Button rightButton = new Button("Go right!");
        rightButton.setTranslateX(600);
        rightButton.setTranslateY(500);
        // event
        rightButton.setOnAction((eventInstructions) -> {
            playGame(right);
        });

        // story text
        Label storyTextLabel = new Label(currentRoom.getStoryText());
        storyTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        storyTextLabel.setTranslateX(100);
        storyTextLabel.setTranslateY(200);

        // background image
        Image bgimage = currentRoom.getBackgroundImage();
        ImageView imageView = new ImageView(bgimage);

        // adding buttons and background to the pane
        playGamePane.getChildren().addAll(imageView, storyTextLabel, leftButton, straightButton, rightButton);
        mainStage.setScene(playGameScene);
    }

    public void lastScene(Room currentRoom) {

        Pane lastScenePane = new Pane();
        Scene lastSceneScene = new Scene(lastScenePane, 700, 600);

        // background image
        Image bgimage = currentRoom.getBackgroundImage();
        ImageView imageView = new ImageView(bgimage);

        // story text
        Label storyTextLabel = new Label(currentRoom.getStoryText());
        storyTextLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        storyTextLabel.setTranslateX(100);
        storyTextLabel.setTranslateY(300);

        // playAgain button
        Button playAgainButton = new Button ("Play again!");
        playAgainButton.setTranslateX(20);
        playAgainButton.setTranslateY(500);
        playAgainButton.setOnAction((eventPlayAgain) -> {
            instructionscreen(nameText);
        });

        // exit button
        Button exitButton = new Button ("Exit game!");
        exitButton.setTranslateX(600);
        exitButton.setTranslateY(500);
        exitButton.setOnAction((eventExit) -> {
            Platform.exit();
        });

        lastScenePane.getChildren().addAll (imageView, playAgainButton, exitButton, storyTextLabel);
        mainStage.setScene(lastSceneScene);
    }
}