import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LudoGame extends Application {
    private int diceValue = 0;
    private int tokenPosition = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Button dice = new Button("🎲 Roll Dice");
        dice.setLayoutX(100);
        dice.setLayoutY(50);
        dice.setOnAction(e -> rollDice());

        Button token = new Button("🔴");
        token.setLayoutX(100);
        token.setLayoutY(150);
        token.setOnAction(e -> moveToken(token));

        root.getChildren().addAll(dice, token);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Ludo Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void rollDice() {
        diceValue = (int) (Math.random() * 6) + 1;
        System.out.println("Dice Rolled: " + diceValue);
    }

    private void moveToken(Button token) {
        if (diceValue == 0) {
            System.out.println("Roll the dice first!");
            return;
        }
        tokenPosition += diceValue * 50; // Example logic
        token.setLayoutX(tokenPosition);
        System.out.println("Token moved to: " + tokenPosition);
        diceValue = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
