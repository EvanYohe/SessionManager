package com.finalproject.session_manager;

// Topic Object Data Structure
public class Topic {

    private int duration;
    private String topic;

    public Topic(String topic, int duration) {

        this.topic = topic;
        this.duration = duration;
    }

    public int getDuration() {

        return duration;
    }
    
    public Integer setDuration(int duration) {
        
        this.duration = duration;
        return duration;
    }

    public String getTopic() {

        return topic;
    }

    public String setTopic(String topic) {

        this.topic = topic;
        return topic;
    }

}