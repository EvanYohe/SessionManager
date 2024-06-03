package com.finalproject.session_manager;

import com.finalproject.command_handler.Command;
import java.util.ArrayList;

public class SessionListBuilder {

    // TODO: Implement session listAll
    public static ArrayList<Session> listAll(Command command){

        // take the JSON array of sessions Main.sessionList
        // return the list of sessions

        return null;
    }

    // TODO: Implement session listSingle
    public static Session listSingle(){

        // take the JSON array of sessions Main.sessionList
        // iterate over JSON array of sessions until the session with the matching ID is found
        // return the session

        return null;
        
    }

    // TODO: Implement session listByKeyword
    public static ArrayList<Session> listByKeyword(){

        // take the JSON array of sessions Main.sessionList
        // iterate over JSON array of sessions
        // grab all sessions with the matching keyword
        // build new arraylist of sessions with matching keyword
        // return the new arraylist
        
        return null;
    }

    // TODO: Implement session listByDateRange
    public static ArrayList<Session> listByDateRange(){

        // take the JSON array of sessions Main.sessionList
        // iterate over JSON array of sessions
        // find the starting date range
        // add each sessions that falls within the date range to a new arraylist
        // return the new arraylist
        
        return null;
    }
}
