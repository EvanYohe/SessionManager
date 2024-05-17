package com.finalproject.session_manager;


// Topic Object Data Structure
public class Topic {

    private int duration;
    private String topic;

    Topic(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
