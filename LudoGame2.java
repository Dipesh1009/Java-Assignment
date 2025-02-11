import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.util.Random;

public class LudoGame2 extends Application {
    // Constants for board size and players
    private static final int BOARD_SIZE = 15;
    private static final int NUM_PLAYERS = 4;
    
    // Game state variables
    private int currentPlayer = 0;
    private Label statusLabel;
    private Button rollButton;
    private Circle[][] boardPieces;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Create main layout container
        VBox root = new VBox(10); // 10 is spacing between elements
        root.setPadding(new Insets(10));

        // Create game board using GridPane
        GridPane board = createBoard();
        
        // Create UI controls
        statusLabel = new Label("Red Player's Turn");
        rollButton = new Button("Roll Dice");
        rollButton.setOnAction(e -> rollDice());

        // Add everything to the root container
        root.getChildren().addAll(statusLabel, board, rollButton);

        // Create and show the scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ludo Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Creates the game board grid
    private GridPane createBoard() {
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);
        boardPieces = new Circle[BOARD_SIZE][BOARD_SIZE];

        // Create board cells
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Circle cell = new Circle(20); // 20 is radius
                cell.setFill(getCellColor(row, col));
                cell.setStroke(Color.BLACK);
                grid.add(cell, col, row);
                boardPieces[row][col] = cell;
            }
        }

        return grid;
    }

    // Determines the color of each cell based on position
    private Color getCellColor(int row, int col) {
        // Home areas
        if (row < 6 && col < 6) return Color.RED;
        if (row < 6 && col > 8) return Color.GREEN;
        if (row > 8 && col < 6) return Color.YELLOW;
        if (row > 8 && col > 8) return Color.BLUE;
        
        // Path cells
        if ((row == 7) || (col == 7)) return Color.WHITE;
        
        // Other cells
        return Color.LIGHTGRAY;
    }

    // Handles dice roll action
    private void rollDice() {
        int roll = random.nextInt(6) + 1;
        String playerColor = getPlayerColor(currentPlayer);
        statusLabel.setText(playerColor + " rolled a " + roll);
        
        // Move to next player
        currentPlayer = (currentPlayer + 1) % NUM_PLAYERS;
        
        // Update status for next turn
        String nextPlayer = getPlayerColor(currentPlayer);
        statusLabel.setText(statusLabel.getText() + "\n" + nextPlayer + "'s Turn");
    }

    // Gets player color based on turn
    private String getPlayerColor(int playerNum) {
        switch (playerNum) {
            case 0: return "Red";
            case 1: return "Green";
            case 2: return "Yellow";
            case 3: return "Blue";
            default: return "";
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}