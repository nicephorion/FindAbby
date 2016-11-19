import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    Stage primaryStage;
    TextField nameText;
    Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        startsceen();

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

        instructionPane.getChildren().addAll(instructions, a1);
        mainStage.setScene(instructionScene);

    }

    public void scene() {

        //Buttons for Scenes
        Button goLeft = new Button("Go left!");
        Button goRight = new Button("Go right!");
        Button goStraight = new Button("Go straight!");

        //Scenes
        //howww? kuhu kirjutada k6igi scene'ide vahelised seosed? siia v6i teise klassi?

//        Scene backgB1 = new Scene();
//        Scene backgB2 = new Scene();
//        Scene backgB3 = new Scene();
//        Scene backgA = new Scene("IMG_0110.png", backgB1, backgB2, backgB3);


    }
}
