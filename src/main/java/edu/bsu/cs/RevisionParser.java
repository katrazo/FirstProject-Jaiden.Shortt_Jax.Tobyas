package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

public class RevisionParser {
    public ArrayList <Revision> parseRevisions(String jsonData) throws IOException {
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

    String getRedirect(String json) {
        String titleRedirectedTo = null;

        try {
            JSONArray redirectionObject = JsonPath.read(json, "$.query.redirects[*]");
            if (!redirectionObject.isEmpty()) {
                titleRedirectedTo = JsonPath.read(redirectionObject.getFirst(), "$.to");
            }
        } catch (PathNotFoundException e) {
            return null;
        }
        return titleRedirectedTo;
    }
}




