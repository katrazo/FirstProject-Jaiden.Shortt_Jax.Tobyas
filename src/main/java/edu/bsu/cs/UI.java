package edu.bsu.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class UI {
    public void getWikiRevisionsFromCLI() throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        ErrorHandlingCLI errorHandlingCLI = new ErrorHandlingCLI();
        String articleInput = getArticleInput();
        errorHandlingCLI.checkEmptyInput(articleInput);
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
