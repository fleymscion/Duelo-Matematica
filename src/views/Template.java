package views;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
            "-fx-padding: 12px 60px; " + // Creates the rectangular banner around text
            "-fx-background-color: #f4f4f4; " +
            "-fx-alignment: center; " +  // Added inner semicolon
            "-fx-text-alignment: center;" // Crucial for centering multi-line wrapped text
        ); // Fixed the broken syntax formatting here

        // 3 Buttons (Notice differing text lengths)
        Button btn1 = createBorderedButton("Option 1");
        Button btn2 = createBorderedButton("Option 2");
        Button btn3 = createBorderedButton("Option 3");

        // Container to stack the buttons vertically
        VBox buttonBox = new VBox(15, btn1, btn2, btn3);
        buttonBox.setAlignment(Pos.CENTER);
        
        // DYNAMIC EQUAL WIDTH: Stretches all child buttons to match the widest button in this box
        buttonBox.setFillWidth(true); 

        // Main root container
        VBox root = new VBox(30, headerLabel, buttonBox);
        root.setAlignment(Pos.CENTER);
        
        // CENTERED BANNER EFFECT: Prevents elements from stretching full window width
        root.setFillWidth(false); 
        root.setStyle("-fx-background-color: #ffffff;");

        // Scene setup
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("JavaFX Menu Sample");
        stage.setScene(scene);
        stage.show();
    }

    private Button createBorderedButton(String text) {
        Button button = new Button(text);

        // Allows button to expand up to the container's calculated max width
        button.setMaxWidth(Double.MAX_VALUE);

        // Fixed height for consistent thickness
        button.setMinHeight(55);
        button.setMaxHeight(55);

        // Border & Styling
        button.setStyle(
            "-fx-font-size: 18px; " +
            "-fx-font-weight: bold; " +
            "-fx-border-color: #000000; " +
            "-fx-border-width: 3px; " +
            "-fx-padding: 10px 30px; " + // Side padding ensures breathing room for text
            "-fx-background-color: #f9f9f9; " +
            "-fx-cursor: hand;"
        );

        // Dummy popup trigger on click
        button.setOnAction(e -> showDummyPopup(text));

        return button;
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
