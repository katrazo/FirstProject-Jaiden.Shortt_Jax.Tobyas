package edu.bsu.cs;

import java.util.ArrayList;
public class RevisionFormatter {

    public StringBuilder formatRevision (ArrayList <Revision> revisionList) {
        StringBuilder revisionOutput = new StringBuilder();

        for (Revision revision : revisionList) {
            revisionOutput.append(revision.getRevisionData());
        }

        return revisionOutput;
    }

}


