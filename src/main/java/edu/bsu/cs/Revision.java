package edu.bsu.cs;

 public class Revision {
    String timestamp;
    String username;
    Revision (String username, String timestamp) {
        this.username = username;
        this.timestamp = timestamp;
    }
    public String getRevisionData(){
        return String.format("%s  %s\n", timestamp, username);
    }
}
