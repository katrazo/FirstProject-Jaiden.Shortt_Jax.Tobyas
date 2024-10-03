package edu.bsu.cs;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class ReadJSONFile {
    public static String connectToWikipedia(String title) throws IOException {
        // Why are these objects?
        ErrorHandlingCLI errorHandlingCLI = new ErrorHandlingCLI();
        ErrorHandlingGUI errorHandlingGUI = new ErrorHandlingGUI();

        // Good. Initially, I made the mistake of "encoding" the entire URL. Oops.
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(title, Charset.defaultCharset()) +
                "&rvprop=timestamp%7Cuser&rvlimit=15&redirects";

        URL url = URI.create(encodedUrlString).toURL();

        // Woah, woah, why are you opening the connection three times? Error handling should check as your doing it the one time.
        errorHandlingCLI.checkConnection(url);
        errorHandlingGUI.checkConnection(url);

        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (haylee.shortt@bsu.edu)");
        connection.connect();

        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}