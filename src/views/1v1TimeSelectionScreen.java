import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Banner Header Title (Centered rectangle in the middle)
        Label headerLabel = new Label("Duelo\nX\nMatematica");
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

        // 4 Buttons
        Button btn1 = createBorderedButton("10 minute");
        Button btn2 = createBorderedButton("25 minute");
        Button btn3 = createBorderedButton("30 minute");
        
        // EXIT Button setup
        Button btn4 = createBorderedButton("EXIT");
        btn4.setOnAction(e -> stage.close()); // Directly closes the application window

        // Container to stack the first 3 buttons horizontally
        HBox buttonBox = new HBox(15, btn1, btn2, btn3);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setFillHeight(true); 

        // Container for the exit button
        VBox exitButtonBox = new VBox(25, btn4);
        exitButtonBox.setAlignment(Pos.CENTER);
        exitButtonBox.setFillWidth(false); 

        // Main content box - ADDED exitButtonBox here so it appears on screen
        VBox centerContent = new VBox(30, headerLabel, buttonBox, exitButtonBox);
        centerContent.setAlignment(Pos.CENTER);
        centerContent.setFillWidth(false); 

        // Gear Icon Button (Bottom Left)
        Button gearButton = createGearButton();
        gearButton.setOnAction(e -> showDummyPopup("Settings"));

        // Outer Root Container (StackPane allows absolute positioning overlay)
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #ffffff;");
        
        // Add content and position gear button at bottom-left with margin padding
        root.getChildren().addAll(centerContent, gearButton);
        StackPane.setAlignment(gearButton, Pos.BOTTOM_LEFT);
        StackPane.setMargin(gearButton, new Insets(20)); // Spacing from window edges

        // Scene setup
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("JavaFX Menu Sample");
        stage.setScene(scene);
        stage.show();
    }

    private Button createBorderedButton(String text) {
        Button button = new Button(text);
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

        button.setOnAction(e -> showDummyPopup(text));
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
        alert.setContentText(buttonName + " clicked! (Functionality not hooked up yet)");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
