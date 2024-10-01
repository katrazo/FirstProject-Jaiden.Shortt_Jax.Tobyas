package edu.bsu.cs;

 public class Revision {
    static String timestamp;
    static String username;
    Revision (String username, String timestamp) {
        Revision.username = username;
        Revision.timestamp = timestamp;
    }
    public String getRevisionData(){
        return String.format("%s  %s\n", timestamp, username);
    }
}
