package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class RevisionParser {
    public static void main(String[] args){
    }
    List<Object> parseRevision(String jsonData){
        Object revision = Configuration.defaultConfiguration().jsonProvider().parse(jsonData);
        return JsonPath.read(revision, "$..revisions[:15].user");
    }
}


