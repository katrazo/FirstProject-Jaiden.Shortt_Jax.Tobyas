package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class RevisionParserTest {
    @Test
    public void revisionParserTest() throws IOException {
        String json = readSampleFileAsString();
        Object revision = Configuration.defaultConfiguration().jsonProvider().parse(json);

        String user = JsonPath.read(revision, "$.query.pages.82425.revisions[0].user");
        Assertions.assertEquals("WikiCleanerMan", user);
    }
    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sample.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }



}