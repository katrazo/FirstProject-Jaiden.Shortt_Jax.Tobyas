package edu.bsu.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) throws IOException {
        // We don't actually care if the CLI throws an error
        // because our only obligation therein is to show the error.
        getWikiRevisionsFromCLI();
    }

    // Coming here from GraphicalUserInterface, I have the same thing to say.
    public static void getWikiRevisionsFromCLI() throws IOException {
        RevisionFormatter revisionFormatter = new RevisionFormatter();
        String articleInput = getArticleInput();
        String jsonData = ReadJSONFile.connectToWikipedia(articleInput);
        ArrayList <Revision> revisionList = RevisionParser.parseRevisions(jsonData);
        checkRedirect(jsonData);
        System.out.println(revisionFormatter.formatRevision(revisionList));
    }

    // This is fine here
    private static String getArticleInput() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter article title:");
        String articleInput = inputReader.nextLine();

        if (articleInput.isEmpty()) {
            System.err.println("No article input provided.");
            System.out.flush();
            articleInput = getArticleInput();
        }

        inputReader.close();
        return articleInput;
    }

    // This is not
    private static void checkRedirect(String jsonData) {
        String titleRedirectedTo = RedirectionParser.getRedirect(jsonData);
        if (titleRedirectedTo != null) {
            System.out.printf("Redirected to %s\n", titleRedirectedTo);
        }
    }
}
