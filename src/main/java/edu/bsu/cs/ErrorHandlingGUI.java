package edu.bsu.cs;

import javafx.scene.control.Alert;

import java.net.URL;

public class ErrorHandlingGUI {
    Alert errorBox = new Alert (Alert.AlertType.NONE);
    public void checkEmptyInput(String articleInput) {
        if (articleInput.isEmpty()) {
            errorBox.setAlertType(Alert.AlertType.ERROR);
            errorBox.setContentText("No article input provided.");
            errorBox.show();
        }
    }

    public void checkConnection(URL connection) {
        try {
            connection.openConnection().connect();
        }
        catch (Exception NetworkError){
            errorBox.setAlertType(Alert.AlertType.ERROR);
            errorBox.setContentText("No connection established.");
            errorBox.show();
        }
    }
}
