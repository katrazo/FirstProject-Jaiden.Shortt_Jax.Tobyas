package edu.bsu.cs;

 public final class Revision {
    static String timestamp;
    static String username;
    Revision (String username, String timestamp) {
        Revision.username = username;
        Revision.timestamp = timestamp;
    }
    public static String getRevisionData(){
        return String.format("%s  %s\n", timestamp, username);
    }
}
