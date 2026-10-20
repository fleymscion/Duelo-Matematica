import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Banner Header Title
        Label headerLabel = createHeaderLabel("MAIN MENU");

        // Buttons
        Button btnStart = createBorderedButton("START");
        Button btnCredits = createBorderedButton("CREDITS");
        Button btnBack = createBorderedButton("BACK");

        // Actions
        btnStart.setOnAction(e -> showDummyPopup("START"));
        btnCredits.setOnAction(e -> showDummyPopup("CREDITS"));
        btnBack.setOnAction(e -> showDummyPopup("BACK"));

        // Button Container
        VBox buttonBox = new VBox(15, btnStart, btnCredits, btnBack);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setFillWidth(true);

        // Center Stack Content
        VBox centerContent = new VBox(30, headerLabel, buttonBox);
        centerContent.setAlignment(Pos.CENTER);
        centerContent.setFillWidth(false);

        // Bottom-Left Gear Icon
        Button gearButton = createGearButton();
        gearButton.setOnAction(e -> showDummyPopup("SETTINGS"));

        // Root Layout
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #ffffff;");
        root.getChildren().addAll(centerContent, gearButton);
        StackPane.setAlignment(gearButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(gearButton, new Insets(20));

        // Scene Setup
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("Screen 2 - Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    private Label createHeaderLabel(String text) {
        Label headerLabel = new Label(text);
        headerLabel.setAlignment(Pos.CENTER);
        headerLabel.setStyle(
            "-fx-font-size: 26px; " +
            "-fx-font-weight: bold; " +
            "-fx-border-color: #222222; " +
            "-fx-border-width: 3px; " +
            "-fx-padding: 12px 60px; " +
            "-fx-background-color: #f4f4f4; " +
            "-fx-alignment: center; " +
            "-fx-text-alignment: center;"
        );
        return headerLabel;
    }

    private Button createBorderedButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMinHeight(55);
        button.setMaxHeight(55);
        button.setStyle(
            "-fx-font-size: 18px; " +
            "-fx-font-weight: bold; " +
            "-fx-border-color: #000000; " +
            "-fx-border-width: 3px; " +
            "-fx-padding: 10px 30px; " +
            "-fx-background-color: #f9f9f9; " +
            "-fx-cursor: hand;"
        );
        return button;
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

    private void showDummyPopup(String buttonName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText(null);
        alert.setContentText(buttonName + " clicked!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
