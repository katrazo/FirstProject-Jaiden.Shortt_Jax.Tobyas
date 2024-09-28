package edu.bsu.cs;

import java.net.URL;


public class ErrorHandling {
    public void checkEmptyInput(String articleInput) {
        if (articleInput.isEmpty()) {
            System.err.println("No article input provided.");
            System.out.flush();
        }
    }

//    public void checkArticleName (String jsonData){
//        String title = JsonPath.read(jsonData, "$.title");
//        if (!title.isEmpty()) {
//            System.err.println("No article found.");
//            System.exit(-1);
//        }


 //   }
    public static void checkConnection(URL connection) {
        try {
            connection.openConnection().connect();
        }
       catch (Exception NetworkError){
            System.err.println("The connection was unable to be established.");
            System.exit(-1);
        }
    }
}
