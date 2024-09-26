package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GraphicalUserInterface extends Application{
    public static void main(String[] args){
        launch(args);
    }

    private final Button getArticleButton = new Button("Get Article");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception {


    }
}
