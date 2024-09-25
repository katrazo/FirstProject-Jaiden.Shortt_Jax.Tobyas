package edu.bsu.cs;

public class Revision {
    String timestamp;
    String username;

    public Revision (String timestamp, String username) {
        this.timestamp = timestamp;
        this.username = username;
    }
    public String getRevisionData(){
        return String.format("Name: %s Timestamp: %s\n", username, timestamp);
    }

}
