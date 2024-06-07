package com.finalproject.data_pipe;

import com.finalproject.Global;
import com.finalproject.session_manager.Session;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReadWriteData {

    public static void writeJsonArray(ArrayList<Session> sessionArray, PrintWriter fileWriter) {

        try {

            fileWriter = new PrintWriter(Global.filePath);
        } catch (IOException e) {

            // TODO: specify the exception and produce a more user-friendly message
            System.err.format("IO exception (most likely permissions writing to file denied) %s%n", e);
        }

        String outputToFile = Global.jsonWriter.toJson(sessionArray);
        fileWriter.println(outputToFile);
        fileWriter.close();
    }

    public static ArrayList<Session> readJsonArray() {

        String jsonFromFile = Global.fileReader.nextLine();

        while (Global.fileReader.hasNextLine()) {

            jsonFromFile += Global.fileReader.nextLine();
        }
        
        Type listType = new TypeToken<ArrayList<Session>>() {}.getType();
        ArrayList<Session> sessionList = Global.jsonWriter.fromJson(jsonFromFile, listType);
        return sessionList;
    }
}
