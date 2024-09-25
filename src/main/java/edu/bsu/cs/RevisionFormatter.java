package edu.bsu.cs;

import java.util.ArrayList;

public class RevisionFormatter {

    public void formatRevision(ArrayList <Revision> revisionList) {
        for (Revision revision : revisionList) {
            revision.getRevisionData();
        }
    }
}