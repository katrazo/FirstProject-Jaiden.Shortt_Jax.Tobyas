package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GraphicalUserInterface extends Application {

    private final Button getArticleButton = new Button("Get Article");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();
    private final TextField redirectField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        redirectField.setEditable(false);
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
        root.getChildren().addAll(
                new Label("Article Title Input:"),
                inputField,
                getArticleButton,
                new Label ("Redirect:"),
                redirectField,
                new Label("Output:"),
                outputField);
        return root;
    }
    private void configureGetArticleButton() {
        getArticleButton.setOnAction(event -> {
            try {
                getWikiRevisions();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void getWikiRevisions() throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();

        String articleInput = inputField.getText();
        String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
        ArrayList<Revision> revisionList = RevisionParser.parseRevisions(jsonData);
        checkRedirect(jsonData);
        String formattedRevisions = String.valueOf(revisionFormatter.formatRevision(revisionList));
        outputField.setText(formattedRevisions);
    }
    private void checkRedirect(String jsonData) {
        String titleRedirectedTo = RevisionParser.getRedirect(jsonData);
        if (titleRedirectedTo != null) {
            redirectField.setText(titleRedirectedTo);
        }
        else {
            redirectField.setText("");
        }
    }

}
