package edu.bsu.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class UI {
    public static void main (String [] args ) throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        ErrorHandling errorHandling = new ErrorHandling();
        String articleInput = getArticleInput();
        errorHandling.checkEmptyInput(articleInput);
        String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
        ArrayList <Revision> revisionList = RevisionParser.parseRevisions(jsonData);
        checkRedirect(jsonData);
        System.out.println(revisionFormatter.formatRevision(revisionList));
    }
    private static String getArticleInput() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter article title:");
        String articleInput = inputReader.nextLine();
        inputReader.close();
        return articleInput;
    }
    private static void checkRedirect(String jsonData) {
        String titleRedirectedTo = RedirectionParser.getRedirect(jsonData);
        if (titleRedirectedTo != null) {
            System.out.printf("Redirected to %s\n", titleRedirectedTo);
        }
    }
}

