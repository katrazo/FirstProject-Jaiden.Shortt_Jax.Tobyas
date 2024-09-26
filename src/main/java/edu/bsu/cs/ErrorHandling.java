package edu.bsu.cs;

public class ErrorHandling {
    public void NoInputError(){
        System.err.println("No article input provided.");
        System.out.flush();
    }

    public void InvalidInputError(){
        System.err.println("The article name provided was not found");
        System.exit(-1);
    }

    public void NetworkError(){
        System.err.println("The connection was unable to be established.");
        System.exit(-1);
    }
}
