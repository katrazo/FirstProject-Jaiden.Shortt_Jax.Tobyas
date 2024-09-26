package edu.bsu.cs;

import java.util.ArrayList;

public class RevisionFormatter {

    //refactor this so that it returns the string to both of the UIs instead of printing here

    public void formatRevision(ArrayList <Revision> revisionList) {
        for (Revision revision : revisionList) {
            System.out.println(revision.getRevisionData());
        }
    }
}