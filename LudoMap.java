import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LudoMap extends Application {

    private static final int TILE_SIZE = 40;  // Size of each tile
    private static final int GRID_SIZE = 17; // 17x17 grid

    @Override
    public void start(Stage primaryStage) {
        GridPane board = new GridPane();

        // Loop to create the 15x15 grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);

                // Set default tile color
                tile.setFill(Color.BEIGE);
                tile.setStroke(Color.BLACK);

                // Customize tiles for each player's home area
                if (row < 7 && col < 7) {
                    tile.setFill(Color.RED);  // Red Player's home
                    tile.setStroke(Color.RED);
                } else if (row < 7 && col > 9) {
                    tile.setFill(Color.BLUE); // Blue Player's home
                    tile.setStroke(Color.BLUE);
                } else if (row > 9 && col < 7) {
                    tile.setFill(Color.GREEN); // Green Player's home
                    tile.setStroke(Color.GREEN);
                } else if (row > 9 && col > 9) {
                    tile.setFill(Color.YELLOW); // Yellow Player's home
                    tile.setStroke(Color.YELLOW);
                } 
                if ((row > 0 && row < 6 && col > 0 && col < 6) || (row < 16 && row > 10 && col > 0 && col < 6) || (row > 0 && row < 6 && col > 10 && col < 16) || (row < 16 && row > 10 && col > 10 && col < 16)) {
                    tile.setFill(Color.AZURE);
                    tile.setStroke(Color.AZURE);
                }
                

                // Add safe zone tiles
                if ((row == 7 && col == 1) || (row == 1 && col == 7) ||
                    (row == 7 && col == 13) || (row == 13 && col == 7)) {
                    tile.setFill(Color.LIGHTGRAY); // Safe zones
                }

                // Add the tile to the grid
                board.add(tile, col, row);
            }
        }
        

        // Create and set the scene
        Scene scene = new Scene(board, TILE_SIZE * GRID_SIZE + 200, TILE_SIZE * GRID_SIZE + 200);
        primaryStage.setTitle("Ludo Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
