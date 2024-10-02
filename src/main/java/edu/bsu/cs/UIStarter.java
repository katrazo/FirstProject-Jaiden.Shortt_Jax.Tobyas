package edu.bsu.cs;

import java.io.IOException;

public class UIStarter {
    public static void main(String[] args) throws IOException {
        UI UserInterface = new UI();
        UserInterface.getWikiRevisionsFromCLI();
    }
}
