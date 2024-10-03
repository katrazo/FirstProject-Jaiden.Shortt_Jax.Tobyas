package edu.bsu.cs;

import java.net.URL;

public class ErrorHandlingCLI {

    // This is fine
    public void checkEmptyInput(String articleInput) {
        if (articleInput.isEmpty()) {
            System.err.println("No article input provided.");
            System.out.flush();
        }
    }

    // Error handling should not be running model code.
    public void checkConnection(URL connection) {
        try {
            connection.openConnection().connect();
        }
       catch (Exception NetworkError){
            System.err.println("The connection was unable to be established.");
            System.out.flush();
        }
    }
}
