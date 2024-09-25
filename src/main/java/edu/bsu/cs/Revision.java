package edu.bsu.cs;

public class Revision {
    String timestamp;
    String username;

    public Revision (String username, String timestamp) {
        this.username = username;
        this.timestamp = timestamp;
    }
    public String getRevisionData(){
        return String.format("Name: %s, Timestamp: %s\n", username, timestamp);
    }
}
