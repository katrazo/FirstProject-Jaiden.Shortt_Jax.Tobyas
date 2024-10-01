package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.util.ArrayList;

public class RevisionParser {
    public static ArrayList <Revision> parseRevisions(String jsonData) {
        JSONArray revisionsFromJson = JsonPath.read(jsonData, "$.query.pages[*].revisions[*]");
        ArrayList<Revision> revisionList = new ArrayList<> (revisionsFromJson.size());

        for (Object revisionObject : revisionsFromJson) {
            String username = JsonPath.read(revisionObject, "$.user");
            String timestamp = JsonPath.read(revisionObject, "$.timestamp");
            Revision revision = new Revision(username, timestamp);
            revisionList.add(revision);
        }
        return revisionList;
    }
}


