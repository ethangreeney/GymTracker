import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WindowBuilder extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(860, 430);
        pane.setStyle("-fx-background-color: #1e1e1e;");

        Label Welcome Label = new Label("Welcome *name");
        Welcome Label.setLayoutX(24.609375);
        Welcome Label.setLayoutY(9.203125);
        Welcome Label.setPrefWidth(105.8125);
        Welcome Label.setPrefHeight(17);
        Welcome Label.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lato.ttf"), 14.00));
        Welcome Label.setStyle("-fx-text-fill: #D9D9D9;");
        pane.getChildren().add(Welcome Label);

        Scene scene = new Scene(pane, 860, 430);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}