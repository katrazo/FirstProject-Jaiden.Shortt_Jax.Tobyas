package edu.bsu.cs;

import java.util.ArrayList;

public class RevisionFormatter {

    public void formatRevision(ArrayList <Object> revisionList) {
        for (Object revision : revisionList) {
            System.out.printf("Revision User:%s", revision);
        }
    }

}