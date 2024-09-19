package edu.bsu.cs;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class RevisionParser {
   public static void main(String[] args) {
//       ReadJSONFile readJSONFile = new ReadJSONFile();
//       String json;
//       try {
//           json = String.valueOf(readJSONFile.getConnection());
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }
//       Object revision = Configuration.defaultConfiguration().jsonProvider().parse(json);
//
//       String revisionUser = JsonPath.read(revision, "$.query.pages.82425.revisions[0].user");
//      System.out.println(revisionUser);
       private void parse() {


           String json = readSampleFileAsString();
           Object revision = Configuration.defaultConfiguration().jsonProvider().parse(json);

           String user = JsonPath.read(revision, "$.query.pages.82425.revisions[0].user");
           System.out.println(user);
       }
   }
    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sample.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }

   }

}
