package edu.bsu.cs;

import javafx.scene.control.Alert;

import java.net.URL;

public class ErrorHandlingGUI {

    Alert errorBox = new Alert (Alert.AlertType.ERROR);

    public void checkEmptyInput(String articleInput) {
        if (articleInput.isEmpty()) {
            errorBox.setContentText("No article input provided.");
            errorBox.show();
        }
    }

    public void checkConnection(URL connection) {
        try {
            connection.openConnection().connect();
        }
        catch (Exception NetworkError){
            errorBox.setContentText("No connection established.");
            errorBox.show();
        }
    }
}
