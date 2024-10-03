package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GraphicalUserInterface extends Application {

    private final Button getArticleButton = new Button("Get Article");
    private final TextField inputField = new TextField();
    private final TextArea outputField = new TextArea();
    private final TextField redirectField = new TextField();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        redirectField.setEditable(false);
        outputField.setMinSize(150,300);
        outputField.setEditable(false);
        configure(primaryStage);
        configureGetArticleButton();
    }

    private void configure(Stage stage) {
        stage.setTitle("Wikipedia Data Parser");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private Pane createRoot() {
        VBox root = new VBox();
        root.setStyle("-fx-padding: 16;" +
                "-fx-border-color: black");
        root.getPadding();
        root.getChildren().addAll(
                new Label("Article Title Input:"), inputField,
                getArticleButton,
                new Label ("Redirect:"), redirectField,
                new Label("Output:"), outputField);
        return root;
    }
    private void configureGetArticleButton() {
        getArticleButton.setOnAction(event -> {
            try {
                inputField.setEditable(false);
                getWikiRevisions();
                inputField.setEditable(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // This method should be somewhere in production code so that you can use it more than once.
    // View-layer code has no business running alllll of this.
    private void getWikiRevisions() throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        ErrorHandlingGUI errorHandlingGUI = new ErrorHandlingGUI();
        String articleInput = inputField.getText();
        errorHandlingGUI.checkEmptyInput(articleInput);
        String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
        ArrayList<Revision> revisionList = RevisionParser.parseRevisions(jsonData);
        checkRedirect(jsonData);
        String formattedRevisions = String.valueOf(revisionFormatter.formatRevision(revisionList));
        outputField.setText(formattedRevisions);
    }

    // Same for this one. It should probably be in the above method.
    private void checkRedirect(String jsonData) {
        String titleRedirectedTo = RedirectionParser.getRedirect(jsonData);
        redirectField.setText(Objects.requireNonNullElse(titleRedirectedTo, ""));
    }

}
