import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage primaryStage;
    Button goLeft = new Button("Go left!");
    Button goRight = new Button("Go right!");
    Button goStraight = new Button("Go straight!");

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane startPane = new Pane();
        Scene startScene = new Scene(startPane, 700, 600);
        primaryStage.setScene(startScene);

        Label startLabel = new Label("Enter your name!");
        TextField nameText = new TextField();
        Button startButton = new Button("Enter!");

        startPane.getChildren().addAll(startLabel, nameText, startButton);
        startLabel.setTranslateX(20);
        startLabel.setTranslateY(20);
        nameText.setTranslateX(20);
        nameText.setTranslateY(60);
        startButton.setTranslateX(20);
        startButton.setTranslateY(100);

        startButton.setOnAction((eventInstructions) -> {
            Pane instructionPane = new Pane();
            Scene instructionScene = new Scene(instructionPane, 700, 600);
            primaryStage.setScene(instructionScene);

            String name = nameText.getText();
            Label instructions = new Label("Hello, " + name + "\nYour" +
                    " sister Abby is missing. \nYou have to find her!");
            instructions.setTranslateX(20);
            instructions.setTranslateY(20);
            Button a1 = new Button("Next!");
            a1.setTranslateX(20);
            a1.setTranslateY(100);

            instructionPane.getChildren().addAll(instructions, a1);

            //nupp a1 tegevus, et saada uuele stseenile bgA1


        });

        primaryStage.show();
    }
}
