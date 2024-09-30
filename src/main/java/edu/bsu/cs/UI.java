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
        inputReader.close();
        errorHandling.checkEmptyInput(articleInput);
        try {
            String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
            ArrayList <Revision> revisionList = revisionParser.parseRevisions(jsonData);
            System.out.println(revisionFormatter.formatRevision(revisionList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void checkRedirect(String jsonData) {
        String titleRedirectedTo = RevisionParser.getRedirect(jsonData);
        if (titleRedirectedTo != null) {
            System.out.printf("Redirected to %s\n", titleRedirectedTo);
        }
    }
}

