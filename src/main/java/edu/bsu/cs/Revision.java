package edu.bsu.cs;

public class Revision {
    static String timestamp;
    static String username;
    public  Revision (String username, String timestamp) {
        Revision.username = username;
        Revision.timestamp = timestamp;
    }
    public static String getRevisionData(){
        return String.format("%s  %s\n", timestamp, username);
    }
}
