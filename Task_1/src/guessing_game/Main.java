package guessing_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gamefx.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.setWidth(480);
        primaryStage.setHeight(420);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}