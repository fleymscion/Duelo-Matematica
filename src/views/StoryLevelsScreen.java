import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private Rectangle greenAsset;
    private TranslateTransition currentTransition;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        Pane gamePane = new Pane();

        // Diagonal target positions
        double[][] buttonPositions = {
            {140, 340}, // Button 1
            {370, 230}, // Button 2
            {600, 60}   // Button 3
        };

        // Green UI Asset Placeholder
        greenAsset = new Rectangle(55, 55);
        greenAsset.setFill(Color.web("#00a800"));
        greenAsset.setStroke(Color.BLACK);
        greenAsset.setStrokeWidth(2);

        // Hardware rendering hints
        greenAsset.setCache(true);
        greenAsset.setCacheHint(CacheHint.SPEED);

        // Initial green asset position (above button 1)
        greenAsset.setTranslateX(buttonPositions[0][0]);
        greenAsset.setTranslateY(buttonPositions[0][1] - 65);

        gamePane.getChildren().add(greenAsset);

        // Red Square Buttons
        for (int i = 0; i < buttonPositions.length; i++) {
            double targetX = buttonPositions[i][0];
            double targetY = buttonPositions[i][1];
            int levelNumber = i + 1;

            Button redBtn = createRedButton();
            redBtn.setLayoutX(targetX);
            redBtn.setLayoutY(targetY);

            // Move green asset, then display story popup upon arrival
            redBtn.setOnAction(e -> moveGreenAssetTo(targetX, targetY - 65, () -> showStoryPopup(levelNumber)));

            gamePane.getChildren().add(redBtn);
        }

        // Overlay Buttons
        Button pauseButton = createPauseButton();
        Button gearButton = createGearButton();

        StackPane root = new StackPane();
        root.getChildren().addAll(gamePane, pauseButton, gearButton);

        StackPane.setAlignment(pauseButton, Pos.TOP_LEFT);
        StackPane.setMargin(pauseButton, new Insets(20));

        StackPane.setAlignment(gearButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(gearButton, new Insets(20));

        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("Duelo Matematica");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Glides green asset to target coordinates, then runs onComplete action.
     */
    private void moveGreenAssetTo(double targetX, double targetY, Runnable onComplete) {
        // If already at target, trigger popup instantly without delay
        if (Math.abs(greenAsset.getTranslateX() - targetX) < 1.0 && 
            Math.abs(greenAsset.getTranslateY() - targetY) < 1.0) {
            if (onComplete != null) {
                onComplete.run();
            }
            return;
        }

        // Stop active transition before creating a fresh one
        if (currentTransition != null) {
            currentTransition.stop();
        }

        currentTransition = new TranslateTransition(Duration.millis(500), greenAsset);
        currentTransition.setInterpolator(Interpolator.EASE_BOTH);
        currentTransition.setToX(targetX);
        currentTransition.setToY(targetY);
        currentTransition.setOnFinished(e -> {
            if (onComplete != null) {
                onComplete.run();
            }
        });
        currentTransition.play();
    }

    /**
     * Displays temporary placeholder dialog for unimplemented story levels.
     */
    private void showStoryPopup(int levelNumber) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(primaryStage); // Ensures popup stays on top of main window
        alert.setTitle("Story Mode");
        alert.setHeaderText(null);
        alert.setContentText("Story not implemented " + levelNumber);
        alert.show(); // Non-blocking show
    }

    private Button createRedButton() {
        Button button = new Button();
        button.setPrefSize(55, 55);
        button.setStyle(
            "-fx-background-color: #a00000; " +
            "-fx-border-color: #000000; " +
            "-fx-border-width: 2px; " +
            "-fx-cursor: hand;"
        );
        return button;
    }

    private Button createPauseButton() {
        Button btn = new Button("II");
        btn.setPrefSize(48, 48);
        btn.setStyle(
            "-fx-font-size: 18px; " +
            "-fx-font-weight: bold; " +
            "-fx-background-color: #e6e6e6; " +
            "-fx-border-color: #000000; " +
            "-fx-border-width: 2px; " +
            "-fx-cursor: hand;"
        );
        return btn;
    }

    private Button createGearButton() {
        Button gearBtn = new Button("\u2699");
        gearBtn.setPrefSize(48, 48);
        gearBtn.setStyle(
            "-fx-font-size: 24px; " +
            "-fx-font-weight: bold; " +
            "-fx-border-color: #000000; " +
            "-fx-border-width: 2px; " +
            "-fx-border-radius: 50%; " +
            "-fx-background-radius: 50%; " +
            "-fx-background-color: #f9f9f9; " +
            "-fx-cursor: hand;"
        );
        return gearBtn;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
