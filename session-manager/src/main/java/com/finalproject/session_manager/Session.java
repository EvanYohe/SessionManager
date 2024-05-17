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

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<Topic> getTopic() {
        return Topic;
    }

    public void setTopic(ArrayList<Topic> topic) {
        Topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    

}
