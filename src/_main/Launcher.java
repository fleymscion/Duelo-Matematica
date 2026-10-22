package _main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.components.*;

public class Launcher extends Application {

	@Override
	public void start(Stage stage) {

		// Create the button using the spritesheet loaded inside Button.java
		// to implement this on other screens,
		// first import button,
		// import views.components.Button
		// then create a button object,
		// Button button = new Button (1), where 1 indicates on how many times the middle part will be repeated
		Button button = new Button(1);

		// to add the text and font size
		button.setText("PLAY");
		button.setFontSize(30);

		// Testing the Duelo font
		Label title = new Label("Welcome");
		title.setFont(Fonts.pixel(34));
		title.setStyle("-fx-text-fill: white;");

		// Display both components in the center of the window, this is jhuust a test to see how it looks okayyyy
		VBox content = new VBox(30, title, button);
		content.setAlignment(javafx.geometry.Pos.CENTER);

		StackPane root = new StackPane(content);
		root.setStyle("-fx-background-color: black;");

		Scene scene = new Scene(root, 800, 600);

		stage.setTitle("Button Component Test");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
