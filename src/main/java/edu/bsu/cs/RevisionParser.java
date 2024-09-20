package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class RevisionParser {
    public static void main(String[] args){

    }
    String parseRevision(String jsonData){
        Object revision = Configuration.defaultConfiguration().jsonProvider().parse(jsonData);
        return JsonPath.read(revision, "$.query.pages.82425.revisions[0].user");
    }
}


