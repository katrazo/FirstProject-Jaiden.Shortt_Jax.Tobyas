package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class ReadJSONFile {

    public static String getRawJson(String jsonData) {
        return jsonData;
    }

    public static String connectToWikipedia(String title) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(title, Charset.defaultCharset()) +
                "&rvprop=timestamp%7Cuser&rvlimit=15&redirects";
        URL url = URI.create(encodedUrlString).toURL();
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (user@bsu.edu)");
        connection.connect();

        InputStream inputStream = connection.getInputStream();

        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());

    }
}