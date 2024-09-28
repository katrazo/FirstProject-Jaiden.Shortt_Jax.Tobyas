package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class RevisionFormatterTest {
    @Test
    public void formatRevision () throws IOException {
        String jsonData = ReadJSONFile.connectToWikipedia("sandwich");
        ArrayList <Revision> revisionList = RevisionParser.parseRevisions(jsonData);
        for (Revision revision : revisionList) {
            System.out.println(Revision.getRevisionData());
        }
    }
}
