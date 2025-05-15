

package hello_world;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        var label = new Label("Hello World");
        label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");
        var root = new StackPane();
        root.getChildren().add(label);
        var scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Simple JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}