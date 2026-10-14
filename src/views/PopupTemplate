import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- POPUP CARD (STANDALONE VBOX) ---
        
        // Header ("LOGIN" + "X" Close Button)
        Label titleLabel = new Label("LOGIN");
        titleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        Button closeButton = new Button("X");
        closeButton.setStyle("-fx-background-color: transparent; -fx-font-weight: bold; -fx-font-size: 14px; -fx-cursor: hand;");
        closeButton.setOnAction(e -> primaryStage.close());

        BorderPane headerBox = new BorderPane();
        headerBox.setCenter(titleLabel);
        headerBox.setRight(closeButton);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        // Input Fields Form Layout
        Label emailLabel = new Label("EMAIL");
        emailLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));

        TextField emailField = new TextField();
        emailField.setPrefWidth(140);
        emailField.setStyle("-fx-background-color: #666666; -fx-text-inner-color: white; -fx-background-radius: 0;");

        Label passwordLabel = new Label("PASSWORD");
        passwordLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(140);
        passwordField.setStyle("-fx-background-color: #666666; -fx-text-inner-color: white; -fx-background-radius: 0;");

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(15);
        formGrid.add(emailLabel, 0, 0);
        formGrid.add(emailField, 1, 0);
        formGrid.add(passwordLabel, 0, 1);
        formGrid.add(passwordField, 1, 1);

        // Forgot Password Link
        Hyperlink forgotPasswordLink = new Hyperlink("FORGOT PASSWORD?");
        forgotPasswordLink.setStyle("-fx-text-fill: black; -fx-underline: false; -fx-font-size: 11px;");

        // Confirm Button
        Button confirmButton = new Button("CONFIRM");
        confirmButton.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        confirmButton.setPrefWidth(130);
        confirmButton.setPrefHeight(35);
        confirmButton.setStyle(
            "-fx-background-color: #999999; " +
            "-fx-text-fill: black; " +
            "-fx-background-radius: 0; " +
            "-fx-cursor: hand;"
        );
        confirmButton.setOnAction(e -> primaryStage.close());

        // Assembly of Inner Layout
        VBox popupLayout = new VBox(15);
        popupLayout.setPadding(new Insets(15, 20, 20, 20));
        popupLayout.setAlignment(Pos.TOP_CENTER);
        popupLayout.getChildren().addAll(headerBox, formGrid, forgotPasswordLink, confirmButton);

        // Root Popup Card Container
        VBox popupCard = new VBox(popupLayout);
        popupCard.setStyle(
            "-fx-background-color: #f4f4f4; " +
            "-fx-border-color: #777777; " +
            "-fx-border-width: 1px;"
        );

        // Display directly as the main scene
        Scene scene = new Scene(popupCard, 280, 260);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
