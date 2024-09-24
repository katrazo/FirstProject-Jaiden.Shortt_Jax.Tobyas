package edu.bsu.cs;

import java.util.ArrayList;

public class RevisionFormatter {
    RevisionParser parser = new RevisionParser();
    ArrayList<Object> revisionList = parser.parseRevision();
    public String formatRevision(){
        for (int numberOfRevisions = 0; numberOfRevisions < 15; numberOfRevisions++) {
            System.out.printf("Revision #%d: User:%s", numberOfRevisions, revision);
        }
    }

}
