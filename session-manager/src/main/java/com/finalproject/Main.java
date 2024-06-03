package com.finalproject;

import com.finalproject.command_handler.Command;
import com.finalproject.command_handler.CommandParser;
import com.finalproject.data_pipe.ReadWriteData;
import com.finalproject.output_formatter.OutputFormatter;
import com.finalproject.session_manager.Session;

import java.util.ArrayList;

public class Main {

    // Main program loop
    public static void main(String[] args) {

        try {
            // on startup, call ReadWriteData.readJsonArray() to load sessions from file
            Global.sessionList = ReadWriteData.readJsonArray();
        } catch (Exception e) {
            // TODO: specify the exception and produce a more user-friendly message
            e.printStackTrace();
        }

        // TEST CODE, REMOVE LATER
        for (Session session : Global.sessionList) {

            System.out.println(session.getSessionID() + 
            " " + session.getDate() + 
            " " + session.getTime() + 
            " " + session.getDuration() + 
            " " + session.getKeywords());
        }

        OutputFormatter.banner();

        for (OutputFormatter.prompt(); Global.userInput.hasNextLine(); OutputFormatter.prompt()) {

            ArrayList<String> argumentList = new ArrayList<>();
            Command command = new Command(
                    Global.userInput.nextLine().replaceAll("\n", " "),
                    argumentList,
                    false,
                    false);

            while (command.isCommandProcessed() == false) {
                CommandParser.parseCommand(command);
            }
        }
    }
}