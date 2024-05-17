package com.finalproject.session_manager;

import java.sql.Time;
import java.util.Date;
import java.util.ArrayList;

// Session Object Data Structure
public class Session {

    private String sessionID;
    private ArrayList<String> keywords;
    private ArrayList<Topic> Topic;
    private Date date;
    private Time time;
    private Time duration;

    Session(String sessionID, ArrayList<String> keywords, ArrayList<Topic> Topic, Date date, Time time, Time duration) {

        this.sessionID = sessionID;
        this.keywords = keywords;
        this.Topic = Topic;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public String getSessionID() {

        return sessionID;
    }

    public String setSessionID(String sessionID) {

        this.sessionID = sessionID;
        return sessionID;
    }

    public ArrayList<String> getKeywords() {

        return keywords;
    }

    public ArrayList<String> setKeywords(ArrayList<String> keywords) {

        this.keywords = keywords;
        return keywords;
    }

    public ArrayList<Topic> getTopic() {

        return Topic;
    }

    public ArrayList<Topic> setTopic(ArrayList<Topic> topic) {

        Topic = topic;
        return topic;
    }

    public Date getDate() {

        return date;
    }

    public Date setDate(Date date) {

        this.date = date;
        return date;
    }

    public Time getTime() {

        return time;
    }

    public Time setTime(Time time) {

        this.time = time;
        return time;
    }

    public Time getDuration() {

        return duration;
    }

    public Time setDuration(Time duration) {

        this.duration = duration;
        return duration;
    }
}