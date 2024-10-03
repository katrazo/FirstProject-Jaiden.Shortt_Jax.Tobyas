package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import net.minidev.json.JSONArray;

public class RedirectionParser {
    static String getRedirect(String jsonData) {
        String titleRedirectedTo = null;

        try {
            JSONArray redirectionObject = JsonPath.read(jsonData, "$.query.redirects[*]");

            if (!redirectionObject.isEmpty())
                titleRedirectedTo = JsonPath.read(redirectionObject.get(0), "$.to");

        } catch (PathNotFoundException e) {
            return null;
        }

        return titleRedirectedTo;
    }
}
