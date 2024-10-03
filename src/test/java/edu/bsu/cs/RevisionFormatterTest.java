package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class RevisionFormatterTest {
    @Test
    public void formatRevision () throws IOException {
        // See ReadJSONFileTest for reasons against this method.
        String json = readSampleFileAsString();

        // Another parse. This should be handled by production code (that is also tested to be valid), not test code.
        Object revisions = Configuration.defaultConfiguration().jsonProvider().parse(json);

        // I see jumping back and forth in this code between ArrayList<> and JSONArray<>.
        // Your best bet is to pick one and stick to it.
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
