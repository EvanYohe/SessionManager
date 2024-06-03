package com.finalproject.session_manager;

import java.util.ArrayList;

// Session Object Data Structure
// This one feels very straightforward and doesn't bear much explanation
// Just a custom data structure to hold the information of each session, with getters and setters
public class Session {

    private String sessionID;
    private ArrayList<String> keywords;
    private String date;
    private String time;
    private String duration;

    public Session() {}
    
    public Session(String date, String time, String duration, ArrayList<String> keywords, String sessionID) {

        this.sessionID = sessionID;
        this.keywords = keywords;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public String getSessionID() {

        return this.sessionID;
    }

    public String setSessionID(String sessionID) {

        this.sessionID = sessionID;
        return sessionID;
    }

    public ArrayList<String> getKeywords() {

        return this.keywords;
    }

    public ArrayList<String> setKeywords(ArrayList<String> keywords) {

        this.keywords = keywords;
        return keywords;
    }

    public String getDate() {

        return this.date;
    }

    public String setDate(String date) {

        this.date = date;
        return date;
    }

    public String getTime() {

        return this.time;
    }

    public String setTime(String time) {

        this.time = time;
        return time;
    }

    public String getDuration() {

        return this.duration;
    }

    public String setDuration(String duration) {

        this.duration = duration;
        return duration;
    }
}