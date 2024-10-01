package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class RevisionFormatterTest {
    @Test
    public void formatRevision () throws IOException {
        String json = readSampleFileAsString();
        Object revisions = Configuration.defaultConfiguration().jsonProvider().parse(json);
        JSONArray revisionsFromJsonFile = JsonPath.read(revisions, "$.query.pages[*].revisions[*]");

        for (Object revision : revisionsFromJsonFile) {
            String username = JsonPath.read(revision, "$.user");
            String timestamp = JsonPath.read(revision, "$.timestamp");
            System.out.printf("%s  %s\n", timestamp, username);
        }

    }
    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sampleData.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }
}
