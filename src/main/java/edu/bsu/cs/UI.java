package edu.bsu.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void main (String [] args ){
        Scanner inputReader = new Scanner(System.in);
        RevisionParser revisionParser = new RevisionParser();
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        ErrorHandling errorHandling = new ErrorHandling();

        System.out.println("Enter article title:");
        String articleInput = inputReader.nextLine();
        if (articleInput == null) errorHandling.NoInputError();
        try {
            String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
            ArrayList <Revision> revisionList = revisionParser.parseRevisions(jsonData);
            System.out.printf("Redirected to %s\n", revisionParser.getRedirect(jsonData));
            revisionFormatter.formatRevision(revisionList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

