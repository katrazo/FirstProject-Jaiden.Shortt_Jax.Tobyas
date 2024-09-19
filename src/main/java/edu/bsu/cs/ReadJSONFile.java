package edu.bsu.cs;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class ReadJSONFile {

    public static void main(String[] args) throws IOException {
        URLConnection connection = connectToWikipedia();
        String jsonData = readJsonAsStringFrom(connection);
        printRawJson(jsonData);
    }

    private static URLConnection connectToWikipedia() throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode("Sandwich", Charset.defaultCharset()) +
                "&rvprop=timestamp%7Cuser&rvlimit=15&redirects";
        URL url = URI.create(encodedUrlString).toURL();
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (user@bsu.edu)");
        connection.connect();
        return connection;
    }

    private static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }

    public URLConnection getConnection() throws IOException {
        return connectToWikipedia();
    }

}
