package com.finalproject.data_pipe;

import com.finalproject.Global;
import com.finalproject.session_manager.Session;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

// Gson based imports


public class ReadWriteData {

    // TODO: Implement writeSession method
    // THIS METHOD NEEDS TO WRITE SESSIONS IN DATE ORDER, OLDEST TO NEWEST
    public static void writeJsonArray(ArrayList<Session> sessionArray, PrintWriter fileWriter){

        // Tried creating as a global variable
        // Kept overwriting the file on init and defeating the purpose
        // of persistent storage
        try {
            fileWriter = new PrintWriter(Global.filePath);
        } catch (Exception e) {
            // TODO: specify the exception and produce a more user-friendly message
            e.printStackTrace();
        }

        // serialize the array of sessions and write to the file using the global fileWriter
        String outputToFile = Global.jsonWriter.toJson(sessionArray);

        System.out.println(outputToFile);

        fileWriter.println(outputToFile);

        fileWriter.close();
        
    }

    // TODO: Implement readSession method
    public static ArrayList<Session> readJsonArray() {
        
        // deserialize the JSON data from file into a string
        String jsonFromFile = Global.fileReader.nextLine();
        while (Global.fileReader.hasNextLine()) {
            jsonFromFile += Global.fileReader.nextLine();
        }

        Type listType = new TypeToken<ArrayList<Session>>(){}.getType();

        // returns the global list of sessions from the json data
        ArrayList<Session> sessionList = Global.jsonWriter.fromJson(jsonFromFile, listType);

        return sessionList;
    }
}
