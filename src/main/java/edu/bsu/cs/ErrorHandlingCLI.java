package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.net.URL;

public class ErrorHandlingCLI {
    public void checkEmptyInput(String articleInput) {
        if (articleInput.isEmpty()) {
            System.err.println("No article input provided.");
            System.out.flush();
        }
    }

    public void checkConnection(URL connection) {
        try {
            connection.openConnection().connect();
        }
       catch (Exception NetworkError){
            System.err.println("The connection was unable to be established.");
            System.out.flush();
        }
    }

    public void checkForInvalidInput(String jsonData){
        String pageValueObject = JsonPath.read(jsonData, "$.query.pages[*]");
        if (pageValueObject.equals("-1")) {
            System.err.println("Wiki page not found.");
            System.out.flush();
        }
    }
}
