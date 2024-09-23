package edu.bsu.cs;

import java.util.ArrayList;

public class RevisionFormatter {
    RevisionParser parser = new RevisionParser();
    ArrayList<Object> revisionList = parser.parseRevision();
}
