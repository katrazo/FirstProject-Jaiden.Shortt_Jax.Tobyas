package edu.bsu.cs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void main (String [] args ){
        Scanner inputReader = new Scanner(System.in);
        ReadJSONFile articleReader = new ReadJSONFile();
        RevisionParser revisionParser = new RevisionParser();
        RevisionFormatter revisionFormatter = new RevisionFormatter();

        System.out.println("Enter article title:");
        String articleInput = inputReader.nextLine();
        try {
            String jsonData = articleReader.connectToWikipedia(articleInput);
            ArrayList<Object> revisionList = revisionParser.parseRevisions(jsonData);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
