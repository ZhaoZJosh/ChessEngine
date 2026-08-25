import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardVisual extends Application {
    private static Board currentBoard;

    public BoardVisual() {
        // JavaFX requires a no-arg constructor for the Application subclass.
    }

    public static void show(Board board) {
        currentBoard = board;
        launch();
    }

    @Override
    public void start(Stage stage) {
        GridPane boardPane = new GridPane();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                StackPane square = new StackPane();
                square.setPrefSize(128, 128);

                Color color = (row + col) % 2 == 0 ? Color.WHITE : Color.SADDLEBROWN;
                square.setStyle("-fx-background-color: " + toHex(color) + ";");

                Image pieceImage = getPieceImage(row, col);
                if (pieceImage != null) {
                    ImageView imageView = new ImageView(pieceImage);
                    imageView.setFitWidth(96);
                    imageView.setFitHeight(96);
                    square.getChildren().add(imageView);
                }

                boardPane.add(square, col, row);
            }
        }

        Scene scene = new Scene(boardPane, 1024, 1024);
        stage.setTitle("Chess Board");
        stage.setScene(scene);
        stage.show();
    }

    private Image getPieceImage(int row, int col) {
        if (currentBoard == null) {
            return null;
        }

        Board.PieceType pieceType = currentBoard.getPieceOnSquare(row, col);
        if (pieceType == null) {
            return null;
        }

        String imagePath = "/images/" + pieceType.name().toLowerCase() + ".png";
        var resource = getClass().getResourceAsStream(imagePath);
        if (resource == null) {
            return null;
        }
        return new Image(resource);
    }

    private static String toHex(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02X%02X%02X", r, g, b);
    }
}
