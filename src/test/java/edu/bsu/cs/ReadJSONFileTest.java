package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReadJSONFileTest {

    static InputStream sampleFile;
    static String jsonData;

    @BeforeAll
    static void setup() throws IOException {
        sampleFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("sampleData.json");
        assert sampleFile != null;
        jsonData = new String(sampleFile.readAllBytes(), Charset.defaultCharset());
    }

    // This is not a necessary test.
    // Tests check the validity of production code;
    // test code should not test the validity of test code, as this defeats the purpose..\
    @Test
    public void testAccessToJsonFile() {
        Assertions.assertNotNull(jsonData);
    }

    // This is good, but it does not test code from ReadJSONFile.java.
    // Also, you should not be creating methods strictly for use in tests.
    //   Especially considering getRevisionFromJson is one line with one usage, just write the line.
    //   The same goes for readSampleFileAsString.
    //     Your tests should not handle errors because they are supposed to have no errors.
    //     Worst case scenario, add "throws ..." to the header.
    // That said, after my restructuring, there are no errors to throw.
    @Test
    public void testCountRevisionsWithJsonPath() {
        JSONArray revisions = JsonPath.read(jsonData, "$..revisions[*]");
        Assertions.assertEquals(4, revisions.size());
    }

}
