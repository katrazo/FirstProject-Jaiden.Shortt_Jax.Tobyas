package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {

    ArrayList<Object> parseRevisions(String jsonData) throws IOException {
        Object revision;
        ArrayList<Object> revisionList = new ArrayList<>();
//needs some sort of handling in case there are less than 15 revisions
        for (int revisionIteration = 0; revisionIteration <= 15; revisionIteration++) {
             revision = JsonPath.read(jsonData, "$.query.pages.82425.revisions[revisionIteration]");
            revisionList.add(revision);
        }
        return revisionList;
    }
}




